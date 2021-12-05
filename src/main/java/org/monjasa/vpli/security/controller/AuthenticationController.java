package org.monjasa.vpli.security.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.security.dto.AccessTokenDto;
import org.monjasa.vpli.security.dto.request.AuthenticationRequest;
import org.monjasa.vpli.security.dto.request.RegistrationRequest;
import org.monjasa.vpli.security.service.AuthenticationService;
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
