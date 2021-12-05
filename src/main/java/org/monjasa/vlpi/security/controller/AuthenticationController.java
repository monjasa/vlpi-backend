package org.monjasa.vlpi.security.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.monjasa.vlpi.security.dto.AccessTokenDto;
import org.monjasa.vlpi.security.dto.request.AuthenticationRequest;
import org.monjasa.vlpi.security.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public AccessTokenDto authenticate(@RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/registration")
    public AccessTokenDto register(@RequestBody RegistrationRequest request) {
        return authenticationService.register(request);
    }
}
