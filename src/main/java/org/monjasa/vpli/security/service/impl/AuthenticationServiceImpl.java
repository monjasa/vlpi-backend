package org.monjasa.vpli.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.security.dto.AccessTokenDto;
import org.monjasa.vpli.security.dto.request.AuthenticationRequest;
import org.monjasa.vpli.security.dto.request.RegistrationRequest;
import org.monjasa.vpli.security.service.AuthenticationService;
import org.monjasa.vpli.security.service.JwtTokenService;
import org.monjasa.vpli.security.service.PrincipalUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final PrincipalUserDetailsService principalUserDetailsService;

    private final JwtTokenService jwtTokenService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AccessTokenDto authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(mapRequestToAuthenticationToken(request));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtTokenService.issueByUserDetails(userDetails);
    }

    @Override
    public AccessTokenDto register(RegistrationRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UserDetails userDetails = principalUserDetailsService.createUser(request);
        return jwtTokenService.issueByUserDetails(userDetails);
    }

    private UsernamePasswordAuthenticationToken mapRequestToAuthenticationToken(AuthenticationRequest request) {
        return new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
    }
}
