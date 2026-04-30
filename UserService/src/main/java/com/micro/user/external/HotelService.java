package com.micro.user.external;


import com.micro.user.dto.HotelDto;
import com.micro.user.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    public HotelDto getHotel(@PathVariable String hotelId);
}