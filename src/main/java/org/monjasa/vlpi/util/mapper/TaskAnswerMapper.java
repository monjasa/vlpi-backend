package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.TaskAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;

@Mapper(componentModel = "spring")
public interface TaskAnswerMapper {

    @Mapping(target = "task.id", source = "taskId")
    @Mapping(target = "exerciseAnswer.id", source = "exerciseAnswerId")
    TaskAnswer toEntity(TaskAnswerRequest taskAnswerRequest);

    TaskAnswerDto toDto(TaskAnswer taskAnswer);

}
