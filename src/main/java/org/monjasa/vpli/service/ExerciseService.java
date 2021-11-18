package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.ExerciseDto;
import org.monjasa.vpli.dto.ExerciseListItemDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseRequest;

import java.util.List;

public interface ExerciseService {

    ExerciseDto getById(Long exerciseId);

    List<ExerciseListItemDto> getAllByModuleId(Long moduleId);

    PersistableDto create(ExerciseRequest request);

}
