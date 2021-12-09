package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.dto.ExerciseAnswerDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;

@Mapper(componentModel = "spring", uses = TaskAnswerMapper.class)
public interface ExerciseAnswerMapper {

    @Mapping(target = "exercise.id", source = "exerciseId")
    ExerciseAnswer toEntity(ExerciseAnswerRequest exerciseAnswerRequest);

    ExerciseAnswerDto toDto(ExerciseAnswer exerciseAnswer);

    PersistableDto toPersistableDto(ExerciseAnswer exerciseAnswer);

}
