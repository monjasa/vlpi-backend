package org.monjasa.vlpi.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.domain.SolutionBlock;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.dto.TaskDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;

@Mapper(componentModel = "spring", uses = SolutionBlockMapper.class)
public interface TaskMapper {

    Task toEntity(TaskRequest request, @Context Exercise exercise);

    TaskDto toDto(Task task);

    PersistableDto toPersistableDto(Task task);

    @AfterMapping
    default void afterToEntity(@MappingTarget Task task, @Context Exercise exercise) {
        task.setExercise(exercise);
        for (SolutionBlock solutionBlock : task.getSolutionBlocks()) {
            solutionBlock.setTask(task);
        }
    }
}
