package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.UserAccountDto;
import org.monjasa.vlpi.dto.UserAccountListItemDto;
import org.monjasa.vlpi.service.UserAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @GetMapping("/current")
    public UserAccountDto getCurrentUserAccount() {
        log.info("Getting user account for authenticated user");
        return userAccountService.getCurrent();
    }

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
