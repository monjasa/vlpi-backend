package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.dto.ExerciseListItemDto;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseListItemDto toListItemDto(Exercise exercise);

}
