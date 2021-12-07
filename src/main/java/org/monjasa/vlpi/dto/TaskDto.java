package org.monjasa.vlpi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskDto {

    private Long id;

    private String question;

    private Integer score;

    private List<SolutionBlockDto> solutionBlocks;

}
