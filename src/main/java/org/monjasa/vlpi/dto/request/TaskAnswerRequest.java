package org.monjasa.vlpi.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskAnswerRequest {

    private Long taskId;

    private Long exerciseAnswerId;

    private List<Long> solutionBlockIds;

}
