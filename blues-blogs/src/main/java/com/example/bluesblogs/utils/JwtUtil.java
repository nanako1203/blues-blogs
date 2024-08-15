package com.example.bluesblogs.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Author nanako
 * @Date 2024/8/15
 * @Description jwt工具类
 */
public class JwtUtil {
    private static final String KEY = "blues";

//    接受业务数据，返回token
    public static String genToken(Map<String, Object> claims)
    {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .sign(Algorithm.HMAC256(KEY));
    }

    //    接受token，返回业务数据
    public static Map<String, Object> parseToken(String token)
    {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
