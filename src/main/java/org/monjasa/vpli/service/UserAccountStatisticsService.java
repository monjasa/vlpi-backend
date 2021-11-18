package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.UserAccountStatisticsDto;

public interface UserAccountStatisticsService {

    UserAccountStatisticsDto getById(Long userAccountId);

}
