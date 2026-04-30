package com.micro.gateway.controller;

import com.micro.gateway.model.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @AuthenticationPrincipal OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) {

        AuthResponse response = new AuthResponse();

        // ✅ user info
        response.setUserId(oidcUser.getEmail());

        // ✅ tokens
        response.setAccessToken(client.getAccessToken().getTokenValue());

        if (client.getRefreshToken() != null) {
            response.setRefreshToken(client.getRefreshToken().getTokenValue());
        }
        List<String> roles = oidcUser.getClaimAsStringList("groups");
        response.setAuthorities(roles);

        return ResponseEntity.ok(response);
    }
}