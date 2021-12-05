package org.monjasa.vlpi.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.security.dto.AccessTokenDto;
import org.monjasa.vlpi.security.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {

    public static final String AUTHORITIES_CLAIM_NAME = "authorities";

    @Value("${spring.security.jwt.secret-key}")
    private String secretKey;

    @Value("${spring.security.jwt.access-token-expires-in}")
    private Long accessTokenExpiresIn;

    @Override
    public AccessTokenDto issueByUserDetails(UserDetails userDetails) {
        Instant issuedAt = Instant.now();
        String accessToken = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(issuedAt))
                .setExpiration(Date.from(issuedAt.plusSeconds(accessTokenExpiresIn)))
                .addClaims(Map.of(AUTHORITIES_CLAIM_NAME, getAuthorities(userDetails)))
                .signWith(decodeSecretKey())
                .compact();

        return AccessTokenDto.builder()
                .accessToken(accessToken)
                .issuedAt(issuedAt)
                .expiresIn(accessTokenExpiresIn)
                .build();
    }

    @Override
    public Claims parse(String access) {
        return Jwts.parserBuilder()
                .setSigningKey(decodeSecretKey())
                .build()
                .parseClaimsJws(access)
                .getBody();
    }

    private List<String> getAuthorities(UserDetails userDetails) {
        return userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    private SecretKey decodeSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
}
