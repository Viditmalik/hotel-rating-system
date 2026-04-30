package com.micro.hotel.dto;


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
