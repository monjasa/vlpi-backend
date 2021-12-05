package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.dto.TaskAnswerResultDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.repository.ExerciseAnswerRepository;
import org.monjasa.vlpi.repository.TaskAnswerRepository;
import org.monjasa.vlpi.service.ExerciseAnswerService;
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
