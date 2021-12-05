package org.monjasa.vpli.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.UserAccountDto;
import org.monjasa.vpli.dto.UserAccountListItemDto;
import org.monjasa.vpli.service.UserAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @GetMapping("/{userAccountId}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public UserAccountDto getById(@PathVariable Long userAccountId) {
        return userAccountService.getById(userAccountId);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public List<UserAccountListItemDto> getAll() {
        return userAccountService.getAll();
    }
}
