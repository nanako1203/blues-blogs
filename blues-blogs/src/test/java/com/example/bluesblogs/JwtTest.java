package com.example.bluesblogs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author nanako
 * @Date 2024/8/15
 * @Description JWT测试
 */
public class JwtTest {
    @Test
    public void testGen()
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "nanako");

        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
    }

    @Test
    public void testParse()
    {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6Im5hbmFrbyJ9LCJleHAiOjE3MjQyOTc5OTd9.TC1isdnbZv4iUKY_TFBL_hEYg7eFaJsDXcM1_O1aIcg";
        JWTVerifier secret = JWT.require(Algorithm.HMAC256("secret")).build();
        DecodedJWT decodedJWT = secret.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.printf("%s", claims.get("user"));

    }
}
