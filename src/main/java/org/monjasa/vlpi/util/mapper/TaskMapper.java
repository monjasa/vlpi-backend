package org.monjasa.vlpi.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.vlpi.domain.SolutionBlock;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.dto.SolutionBlockDto;
import org.monjasa.vlpi.dto.TaskDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;

import java.util.Comparator;

@Mapper(componentModel = "spring", uses = SolutionBlockMapper.class)
public interface TaskMapper {

    @Mapping(target = "exercise.id", source = "exerciseId")
    Task toEntity(TaskRequest request);

    TaskDto toDto(Task task);

    PersistableDto toPersistableDto(Task task);

    @AfterMapping
    default void afterToEntity(@MappingTarget Task task) {
        for (SolutionBlock solutionBlock : task.getSolutionBlocks()) {
            solutionBlock.setTask(task);
        }
    }

    @AfterMapping
    default void afterToDto(@MappingTarget TaskDto taskDto) {
        taskDto.getSolutionBlocks().sort(Comparator.comparing(SolutionBlockDto::getText));
    }
}
