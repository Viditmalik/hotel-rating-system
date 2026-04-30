package com.micro.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Rating {

    @Id
    private String userId;
    private String ratingId;
    private String hotelId;
    private int rating;
    private String feedback;
}
