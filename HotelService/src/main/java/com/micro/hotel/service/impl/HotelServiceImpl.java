package com.micro.hotel.service.impl;

import com.micro.hotel.dto.HotelDto;
import com.micro.hotel.entity.Hotel;
import com.micro.hotel.exceptions.ResourceNotFoundException;
import com.micro.hotel.repository.HotelRepository;
import com.micro.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // ================= CREATE =================
    @Override
    public HotelDto createHotel(HotelDto hotelDto) {

        Hotel hotel = mapToEntity(hotelDto);

        String hotelID = UUID.randomUUID().toString();
        hotel.setId(hotelID);

        Hotel saved = hotelRepository.save(hotel);

        return mapToDto(saved);
    }

    // ================= GET ALL =================
    @Override
    public List<HotelDto> getAllHotels() {

        return hotelRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }


    @Override
    @Cacheable(value = "hotelsCache", key = "#id")
    public HotelDto getHotelById(String id) {

        System.out.println("DB CAll for hotel id: "+ id);

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));

        return mapToDto(hotel);
    }

    // ================= MAPPING =================

    private HotelDto mapToDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .about(hotel.getAbout())
                .build();
    }

    private Hotel mapToEntity(HotelDto dto) {
        return Hotel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .about(dto.getAbout())
                .build();
    }
}