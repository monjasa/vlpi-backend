package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;

@Mapper(componentModel = "spring")
public interface ExerciseAnswerMapper {

    @Mapping(target = "exercise.id", source = "exerciseId")
    ExerciseAnswer toEntity(ExerciseAnswerRequest exerciseAnswerRequest);

    PersistableDto toPersistableDto(ExerciseAnswer exerciseAnswer);

}
