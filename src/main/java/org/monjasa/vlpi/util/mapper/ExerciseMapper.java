package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(target = "module.id", source = "moduleId")
    Exercise toEntity(ExerciseRequest request);

    @Mapping(target = "tasks", ignore = true)
    ExerciseDto toDto(Exercise exercise);

    ExerciseListItemDto toListItemDto(Exercise exercise);

    PersistableDto toPersistableDto(Exercise exercise);

}
