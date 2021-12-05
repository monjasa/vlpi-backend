package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.dto.UserAccountStatisticsDto;
import org.monjasa.vlpi.repository.UserAccountRepository;
import org.monjasa.vlpi.service.ExerciseAnswerService;
import org.monjasa.vlpi.service.UserAccountStatisticsService;
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
