package org.monjasa.vlpi.security.service;

import io.jsonwebtoken.Claims;
import org.monjasa.vlpi.security.dto.AccessTokenDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {

    AccessTokenDto issueByUserDetails(UserDetails userDetails);

    Claims parse(String token);

}
