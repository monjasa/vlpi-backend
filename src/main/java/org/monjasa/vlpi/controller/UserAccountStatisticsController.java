package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.UserAccountStatisticsDto;
import org.monjasa.vlpi.service.UserAccountStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/user-statistics")
@RequiredArgsConstructor
public class UserAccountStatisticsController {

    private final UserAccountStatisticsService userAccountStatisticsService;

    @GetMapping("/current")
    public UserAccountStatisticsDto getCurrentUserAccountStatistics() {
        log.info("Getting user account statistics for authenticated user");
        return userAccountStatisticsService.getCurrent();
    }
}
