package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.TaskAnswerResultDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;

public interface ExerciseAnswerService {

    PersistableDto create(ExerciseAnswerRequest request);

    TaskAnswerResultDto createTaskAnswer(Long exerciseAnswerId, TaskAnswerRequest request);

}
