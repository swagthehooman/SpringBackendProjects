package com.swagnik.todo.Services.AuthenticationService;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenGenerationService {

    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication auth) {
        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(Instant.now())
                .issuer("self")
                .subject(auth.getName())
                .claim("roles", scope)
                .expiresAt(Instant.now().plusSeconds(100000))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
