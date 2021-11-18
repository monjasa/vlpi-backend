package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.TaskAnswerResultDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseAnswerRequest;
import org.monjasa.vpli.dto.request.TaskAnswerRequest;

public interface ExerciseAnswerService {

    PersistableDto create(ExerciseAnswerRequest request);

    TaskAnswerResultDto createTaskAnswer(Long exerciseAnswerId, TaskAnswerRequest request);

}
