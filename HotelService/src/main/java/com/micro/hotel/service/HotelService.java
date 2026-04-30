package com.micro.hotel.service;



import com.micro.hotel.dto.HotelDto;
import com.micro.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    List<HotelDto> getAllHotels();

    HotelDto getHotelById(String id);
}
