package org.monjasa.vlpi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseRequest {

    private String name;

    private String description;

    private Long moduleId;

}
