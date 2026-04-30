package com.micro.user.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private String userId;
    private String name;
    private String email;
    private String about;
    private List<RatingDto> ratings;

}
