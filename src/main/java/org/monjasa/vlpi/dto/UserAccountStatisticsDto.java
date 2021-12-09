package org.monjasa.vlpi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class UserAccountStatisticsDto {

    private Integer exerciseAnswersCount;

    private Integer taskAnswersCount;

    private Integer taskAnswersTotalScore;

    private BigDecimal solutionsToTaskAnswersRatio;

}
