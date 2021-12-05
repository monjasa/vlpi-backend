package org.monjasa.vpli.security.service;

import io.jsonwebtoken.Claims;
import org.monjasa.vpli.security.dto.AccessTokenDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {

    AccessTokenDto issueByUserDetails(UserDetails userDetails);

    Claims parse(String token);

}
