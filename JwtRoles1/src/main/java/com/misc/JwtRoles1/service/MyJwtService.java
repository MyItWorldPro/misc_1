package com.misc.JwtRoles1.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyJwtService {

    //generate this secret from: https://www.allkeysgenerator.com/
    public static final String SECRET = "6351665468576D5A7134743777217A25432A462D4A614E645267556B586E3272";

    public String generateTokenFromMyUsername(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createMyToken(claims, userName);
    }

    private String createMyToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))//valid for 30 minutes
                .signWith(getMySignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getMySignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
