package com.micro.rating.impl;

import com.micro.rating.dto.RatingDto;
import com.micro.rating.entity.Rating;
import com.micro.rating.repository.RatingRepository;
import com.micro.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // ================= CREATE =================
    @Override
    public RatingDto createRating(RatingDto ratingDto) {

        Rating rating = mapToEntity(ratingDto);

        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);

        Rating saved = ratingRepository.save(rating);

        return mapToDto(saved);
    }

    // ================= GET ALL =================
    @Override
    public List<RatingDto> getAllRatings() {

        return ratingRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // ================= GET BY USER =================
    @Override
    public List<RatingDto> getRatingByUserId(String userId) {

        return ratingRepository.getRatingByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // ================= GET BY HOTEL =================
    @Override
    public List<RatingDto> getRatingByHotelId(String hotelId) {

        return ratingRepository.getRatingByHotelId(hotelId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // ================= MAPPING =================

    private RatingDto mapToDto(Rating rating) {
        return RatingDto.builder()
                .ratingId(rating.getRatingId())
                .userId(rating.getUserId())
                .hotelId(rating.getHotelId())
                .rating(rating.getRating())
                .feedback(rating.getFeedback())
                .build();
    }

    private Rating mapToEntity(RatingDto dto) {
        return Rating.builder()
                .ratingId(dto.getRatingId())
                .userId(dto.getUserId())
                .hotelId(dto.getHotelId())
                .rating(dto.getRating())
                .feedback(dto.getFeedback())
                .build();
    }
}