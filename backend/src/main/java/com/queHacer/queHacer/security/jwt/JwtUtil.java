package com.queHacer.queHacer.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    public static String generateToken(User user){
        return Jwts
                .builder()
                .subject(user.getUsername())
                .claim("roles", user.getAuthorities())
                .expiration(new Date(System.currentTimeMillis() + 300_000_000))
                .signWith(getSigningKey())
                .compact();
    }

    public static Claims getClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static boolean isTokenValid(String token){
        return !isExpired(token);
    }

    private static boolean isExpired(String token) {
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }


    private static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode("ArribaElAmericaTricampeonHijosDeSuChingadaMadre");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
