package com.micro.user.external;

import com.micro.user.dto.RatingDto;
import com.micro.user.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    public List<RatingDto>  getRatingsByUserId(@PathVariable String userId);
}
