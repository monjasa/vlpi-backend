package org.monjasa.vpli.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.UserAccountStatisticsDto;
import org.monjasa.vpli.repository.UserAccountRepository;
import org.monjasa.vpli.service.ExerciseAnswerService;
import org.monjasa.vpli.service.UserAccountStatisticsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountStatisticsServiceImpl implements UserAccountStatisticsService {

    private final ExerciseAnswerService exerciseAnswerService;

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserAccountStatisticsDto getById(Long userAccountId) {
        throw new UnsupportedOperationException();
    }
}
