package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.dto.UserAccountStatisticsDto;
import org.monjasa.vlpi.service.UserAccountStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/statistics")
@RequiredArgsConstructor
public class UserAccountStatisticsController {

    private final UserAccountStatisticsService userAccountStatisticsService;

    @GetMapping("/{userAccountId}")
    public UserAccountStatisticsDto getById(@PathVariable Long userAccountId) {
        return userAccountStatisticsService.getById(userAccountId);
    }
}