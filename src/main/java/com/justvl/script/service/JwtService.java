package com.justvl.script.service;


import com.justvl.script.dto.UserData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Getter
    @Value("${jwt.lifetime}")
    private long lifetime;

    private SecretKey secretKey;

    @PostConstruct
    protected void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(long userId, String username) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("username", username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + lifetime))
                .signWith(getSingKey())
                .compact();
    }

    public UserData extractData(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return new UserData(
                Long.parseLong(claims.getSubject()),
                claims.get("username", String.class)
        );
    }

    public String parseUsername(String token) {
        return extractData(token).getUsername();
    }

    private SecretKey getSingKey() {
        return secretKey;
    }

}
