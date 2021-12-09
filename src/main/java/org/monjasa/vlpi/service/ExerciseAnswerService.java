package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.ExerciseAnswerDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;

import java.util.List;

public interface ExerciseAnswerService {

    List<ExerciseAnswerDto> getAllByUserAccountId(Long userAccountId);

    PersistableDto create(ExerciseAnswerRequest exerciseAnswerRequest);

}
