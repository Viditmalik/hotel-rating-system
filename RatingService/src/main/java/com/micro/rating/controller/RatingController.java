package com.micro.rating.controller;

import com.micro.rating.dto.RatingDto;
import com.micro.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // CREATE
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.createRating(ratingDto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    // GET BY USER
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    // GET BY HOTEL
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingDto>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}