package com.micro.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingDto {
    private String userId;
    private String ratingId;
    private String hotelId;
    private int rating;
    private String feedback;
    private HotelDto hotel;



}
