package org.monjasa.vlpi.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskRequest {

    private String question;

    private Integer score;

    private Long exerciseId;

    private List<SolutionBlockRequest> solutionBlocks;

}
