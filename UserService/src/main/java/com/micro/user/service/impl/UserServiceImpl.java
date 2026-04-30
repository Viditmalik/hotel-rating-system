package com.micro.user.service.impl;

import com.micro.user.dto.HotelDto;
import com.micro.user.dto.RatingDto;
import com.micro.user.dto.UserDto;
import com.micro.user.entity.Hotel;
import com.micro.user.entity.Rating;
import com.micro.user.entity.Users;
import com.micro.user.exceptions.ResourceNotFoundException;
import com.micro.user.external.HotelService;
import com.micro.user.external.RatingService;
import com.micro.user.repository.UserRepository;
import com.micro.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private HotelService hotelService;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    // ================== SAVE USER ==================
    @Override
    public UserDto saveUser(UserDto userDto) {

        Users user = mapToEntity(userDto);

        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);

        Users savedUser = userRepository.save(user);

        return mapToDto(savedUser);
    }

    // ================== GET ALL USERS ==================
    @Override
    public List<UserDto> getAllUsers() {

        List<Users> users = userRepository.findAll();

        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    // ================== GET USER BY ID ==================
    @Override
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingRetry", fallbackMethod = "ratingHotelFallback")
    @CircuitBreaker(name = "User_Service_Rating_Breaker", fallbackMethod = "ratingHotelFallback")
    public UserDto getUserById(String userId) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        // Fetch ratings
        List<RatingDto> ratings = ratingService.getRatingsByUserId(userId);


        List<RatingDto> ratingDto = ratings.stream().map(rating -> {

            HotelDto hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;

        }).toList();

        UserDto userDto = mapToDto(user);
        userDto.setRatings(ratingDto);

        return userDto;
    }

    // ================== FALLBACK ==================
    public UserDto ratingHotelFallback(String userId, Exception ex) {

        logger.error("Fallback triggered for userId:{} due to:{}", userId, ex.getMessage());

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserDto userDto = mapToDto(user);
        userDto.setRatings(Collections.emptyList());
        userDto.setAbout("Ratings service is temporarily unavailable");

        return userDto;
    }

    // ================== DELETE ==================
    @Override
    public UserDto deleteUserById(String userId) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        userRepository.delete(user);

        return mapToDto(user);
    }

    // ================== MAPPING ==================

    private UserDto mapToDto(Users user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .about(user.getAbout())
                .build();
    }

    private Users mapToEntity(UserDto dto) {
        return Users.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .email(dto.getEmail())
                .about(dto.getAbout())
                .build();
    }
}