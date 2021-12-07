package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;
import org.monjasa.vlpi.dto.request.TaskRequest;

import java.util.List;

public interface ExerciseService {

    ExerciseDto getById(Long exerciseId);

    List<ExerciseListItemDto> getAllByModuleId(Long moduleId);

    PersistableDto create(ExerciseRequest exerciseRequest);

    PersistableDto createTaskByExerciseId(Long exerciseId, TaskRequest taskRequest);

}
