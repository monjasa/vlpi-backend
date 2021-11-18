package org.monjasa.vpli.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.UserAccountDto;
import org.monjasa.vpli.dto.UserAccountListItemDto;
import org.monjasa.vpli.dto.request.UserAccountAuthenticationRequest;
import org.monjasa.vpli.dto.request.UserAccountRegistrationRequest;
import org.monjasa.vpli.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @GetMapping("/{userAccountId}")
    public UserAccountDto getById(@PathVariable Long userAccountId) {
        return userAccountService.getById(userAccountId);
    }

    @GetMapping
    public List<UserAccountListItemDto> getAll() {
        return userAccountService.getAll();
    }

    @PostMapping("/registration")
    public void register(@RequestBody UserAccountRegistrationRequest request) {
        userAccountService.register(request);
    }

    @PostMapping("/authentication")
    public void authenticate(@RequestBody UserAccountAuthenticationRequest request) {
        userAccountService.authenticate(request);
    }
}
