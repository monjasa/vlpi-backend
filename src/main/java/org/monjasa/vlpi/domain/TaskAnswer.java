package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class TaskAnswer extends AuditableEntity {

    private Integer score;

    private Boolean isSolution;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseAnswer exerciseAnswer;

}
