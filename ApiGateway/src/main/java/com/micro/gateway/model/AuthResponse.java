package com.micro.gateway.model;

import lombok.*;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;

    private Collection<String> authorities;
}
