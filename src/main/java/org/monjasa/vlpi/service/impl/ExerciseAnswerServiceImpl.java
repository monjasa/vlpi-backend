package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.exception.NotFoundException;
import org.monjasa.vlpi.repository.ExerciseAnswerRepository;
import org.monjasa.vlpi.security.service.PrincipalUserDetailsService;
import org.monjasa.vlpi.service.ExerciseAnswerService;
import org.monjasa.vlpi.service.TaskAnswerService;
import org.monjasa.vlpi.util.mapper.ExerciseAnswerMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseAnswerServiceImpl implements ExerciseAnswerService {

    private final PrincipalUserDetailsService principalUserDetailsService;

    private final TaskAnswerService taskAnswerService;

    private final ExerciseAnswerRepository exerciseAnswerRepository;

    private final ExerciseAnswerMapper exerciseAnswerMapper;

    @Override
    public PersistableDto create(ExerciseAnswerRequest exerciseAnswerRequest) {
        ExerciseAnswer exerciseAnswer = exerciseAnswerMapper.toEntity(exerciseAnswerRequest);
        exerciseAnswer.setUserAccount(principalUserDetailsService.loadAuthenticatedUser());

        return exerciseAnswerMapper.toPersistableDto(exerciseAnswerRepository.save(exerciseAnswer));
    }

    @Override
    public TaskAnswerDto createTaskAnswerByExerciseAnswerId(
            Long exerciseAnswerId,
            TaskAnswerRequest taskAnswerRequest) {
        ExerciseAnswer exerciseAnswer = exerciseAnswerRepository.findById(exerciseAnswerId)
                .orElseThrow(NotFoundException::new);
        return taskAnswerService.create(taskAnswerRequest, exerciseAnswer);
    }
}
