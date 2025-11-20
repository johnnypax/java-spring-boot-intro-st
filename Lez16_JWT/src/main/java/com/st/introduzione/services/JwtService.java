package com.st.introduzione.services;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET = "a-string-secret-at-least-256-bits-long";
	
	private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }
	
	public String generateToken(String user) {
		return Jwts.builder()
				.subject(user)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(getSigningKey(), Jwts.SIG.HS256)
				.compact();
	}
	
	public String extractUsername(String token) {
		return Jwts.parser()
				.verifyWith(getSigningKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean validate(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}
