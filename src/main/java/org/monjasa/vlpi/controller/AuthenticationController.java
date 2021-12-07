package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.security.dto.AccessTokenDto;
import org.monjasa.vlpi.security.dto.request.AuthenticationRequest;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.monjasa.vlpi.security.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public AccessTokenDto authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        log.info("Processing authentication request for username: {}", authenticationRequest.getUsername());
        return authenticationService.authenticate(authenticationRequest);
    }

    @PostMapping("/registration")
    public AccessTokenDto register(@RequestBody RegistrationRequest registrationRequest) {
        log.info("Processing registration request for username: {}", registrationRequest.getUsername());
        return authenticationService.register(registrationRequest);
    }
}
