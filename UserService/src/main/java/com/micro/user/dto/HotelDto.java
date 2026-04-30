package com.micro.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
    private String id;
    private String name;
    private String location;
    private String about;


}
