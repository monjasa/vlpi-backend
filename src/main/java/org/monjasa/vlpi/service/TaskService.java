package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.TaskDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllByExerciseId(Long exerciseId);

    PersistableDto create(TaskRequest taskRequest);

    void deleteById(Long taskId);

}
