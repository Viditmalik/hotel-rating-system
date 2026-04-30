package com.micro.rating.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingDto {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}