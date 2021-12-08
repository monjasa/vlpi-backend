package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;

public interface ExerciseAnswerService {

    PersistableDto create(ExerciseAnswerRequest exerciseAnswerRequest);

}
