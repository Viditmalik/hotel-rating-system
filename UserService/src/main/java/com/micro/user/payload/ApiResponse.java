package com.micro.user.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.service.annotation.GetExchange;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus status;
}
