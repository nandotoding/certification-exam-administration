package com.test.certificationexamadministration.util;

import com.test.certificationexamadministration.exception.UnauthorizedException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Integer jwtExp;

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExp))
                .compact();
    }

    public boolean validateToken(String token) {
        if (token == null) {
            throw new UnauthorizedException("Unauthorized access");
        }

        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new UnauthorizedException("Token is expired");
        } catch (UnsupportedJwtException e) {
            throw new UnauthorizedException("Token is not supported");
        } catch (MalformedJwtException e) {
            throw new UnauthorizedException("Token is malformed");
        } catch (SignatureException e) {
            throw new UnauthorizedException("Signature is unknown");
        }
    }
}
