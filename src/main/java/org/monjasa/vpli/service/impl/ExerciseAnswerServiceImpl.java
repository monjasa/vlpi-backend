package org.monjasa.vpli.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.TaskAnswerResultDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseAnswerRequest;
import org.monjasa.vpli.dto.request.TaskAnswerRequest;
import org.monjasa.vpli.repository.ExerciseAnswerRepository;
import org.monjasa.vpli.repository.TaskAnswerRepository;
import org.monjasa.vpli.service.ExerciseAnswerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseAnswerServiceImpl implements ExerciseAnswerService {

    private final ExerciseAnswerRepository exerciseAnswerRepository;

    private final TaskAnswerRepository taskAnswerRepository;

    @Override
    public PersistableDto create(ExerciseAnswerRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TaskAnswerResultDto createTaskAnswer(Long exerciseAnswerId, TaskAnswerRequest request) {
        throw new UnsupportedOperationException();
    }
}
