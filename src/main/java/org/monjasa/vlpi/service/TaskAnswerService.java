package org.monjasa.vlpi.service;

import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;

public interface TaskAnswerService {

    TaskAnswerDto create(TaskAnswerRequest taskAnswerRequest, ExerciseAnswer exerciseAnswer);

}
