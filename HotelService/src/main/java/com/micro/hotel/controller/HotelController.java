package com.micro.hotel.controller;

import com.micro.hotel.dto.HotelDto;
import com.micro.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // CREATE
    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.createHotel(hotelDto));
    }

    // GET SINGLE
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}