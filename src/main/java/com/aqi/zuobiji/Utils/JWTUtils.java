package com.aqi.zuobiji.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtils {
    
    public static final String AUTH_HEADER_KEY = "Authorization";
    
    public static final String TOKEN_PREFIX = "Bearer";
    
    /** 过期时间：四小时*/
    private static final long EXPIRE_TIME = 1 * 4 * 60 * 60 *1000;

    /** 密钥*/
    private static final String secret = "43dcbc5b-8776-429e-b122-3cae6bd97020";
    
    public static String sign(Integer id){
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);

            /** 附带id信息    */
            String token = JWT.create()
                    // .withHeader(HashMap()) 可以不带，有默认
                    .withClaim("id", id)    //携带的信息
                    .withExpiresAt(date)    //过期时间
                    .sign(algorithm);   //根据密钥secret签发
            return token;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();   //通过secret校验
            DecodedJWT jwt = jwtVerifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Integer getUserId(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asInt();
        } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
