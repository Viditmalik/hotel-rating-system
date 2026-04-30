package com.micro.hotel.repository;

import com.micro.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
