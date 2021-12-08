package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TaskAnswer extends AuditableEntity {

    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExerciseAnswer exerciseAnswer;

}
