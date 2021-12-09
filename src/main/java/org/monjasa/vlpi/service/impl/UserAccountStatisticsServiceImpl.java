package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.UserAccount;
import org.monjasa.vlpi.dto.ExerciseAnswerDto;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.UserAccountStatisticsDto;
import org.monjasa.vlpi.security.service.PrincipalUserDetailsService;
import org.monjasa.vlpi.service.ExerciseAnswerService;
import org.monjasa.vlpi.service.UserAccountStatisticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAccountStatisticsServiceImpl implements UserAccountStatisticsService {

    public static final int RATIO_SCALE = 2;

    private final ExerciseAnswerService exerciseAnswerService;

    private final PrincipalUserDetailsService principalUserDetailsService;

    @Override
    public UserAccountStatisticsDto getCurrent() {
        UserAccount userAccount = principalUserDetailsService.loadAuthenticatedUser();
        List<ExerciseAnswerDto> exerciseAnswers = exerciseAnswerService.getAllByUserAccountId(userAccount.getId());

        return UserAccountStatisticsDto.builder()
                .exerciseAnswersCount(exerciseAnswers.size())
                .taskAnswersCount(getTaskAnswersCount(exerciseAnswers))
                .taskAnswersTotalScore(getTaskAnswersTotalScore(exerciseAnswers))
                .solutionsToTaskAnswersRatio(getSolutionsToTaskAnswersRatio(exerciseAnswers))
                .build();
    }

    private int getTaskAnswersCount(List<ExerciseAnswerDto> exerciseAnswers) {
        return exerciseAnswers.stream()
                .map(ExerciseAnswerDto::getTaskAnswers)
                .mapToInt(Collection::size)
                .sum();
    }

    private int getTaskAnswersTotalScore(List<ExerciseAnswerDto> exerciseAnswers) {
        return exerciseAnswers.stream()
                .map(ExerciseAnswerDto::getTaskAnswers)
                .flatMap(Collection::stream)
                .mapToInt(TaskAnswerDto::getScore)
                .sum();
    }

    private BigDecimal getSolutionsToTaskAnswersRatio(List<ExerciseAnswerDto> exerciseAnswers) {
        List<TaskAnswerDto> taskAnswers = exerciseAnswers.stream()
                .map(ExerciseAnswerDto::getTaskAnswers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (taskAnswers.isEmpty()) {
            return BigDecimal.ZERO;
        }

        long taskAnswersCount = taskAnswers.size();
        long solutionsCount = taskAnswers.stream()
                .filter(TaskAnswerDto::getIsSolution)
                .count();

        return BigDecimal.valueOf(solutionsCount)
                .divide(BigDecimal.valueOf(taskAnswersCount), RATIO_SCALE, RoundingMode.HALF_UP);
    }
}
