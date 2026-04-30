package com.micro.rating.repository;

import com.micro.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> getRatingByHotelId(String hotelId);
    List<Rating> getRatingByUserId(String userId);
}
