package com.micro.rating.service;

import com.micro.rating.dto.RatingDto;
import com.micro.rating.entity.Rating;

import java.util.List;

public interface RatingService {


    //create rating
    RatingDto createRating(RatingDto ratingDto);



    //get all ratings
    List<RatingDto> getAllRatings();



    // get all ratings by userId
    List<RatingDto> getRatingByUserId(String userId);



    //get all ratings by HotelId
    List<RatingDto> getRatingByHotelId(String hotelId);
}
