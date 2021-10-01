package com.devproject.tediproject.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.devproject.tediproject.security.SecurityConstant.*;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;



//    @Value("${app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(Integer.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }




//
//    public String generateJwtToken(Authentication authentication){
//        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
////        String[] claims = getClaimsFromUser(userPrincipal);
//        return JWT.create().withIssuer(GET_ARRAYS_LLC).withAudience(GET_ARRAYS_ADMINISTRATOR)
//                .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername())
////                .withArrayClaim(AUTHORITIES, claims)
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(secret.getBytes()));
//    }



    public Integer getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        }
//        catch (SignatureException ex) {
////            logger.error("Invalid JWT signature");
//        }

        catch (MalformedJwtException ex) {
//            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
//            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
//            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
//            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}