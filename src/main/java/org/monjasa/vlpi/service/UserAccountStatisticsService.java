package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.UserAccountStatisticsDto;

public interface UserAccountStatisticsService {

    UserAccountStatisticsDto getById(Long userAccountId);

}
