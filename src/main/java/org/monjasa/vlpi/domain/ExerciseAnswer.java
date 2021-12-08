package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ExerciseAnswer extends AuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @OneToMany(mappedBy = "exerciseAnswer", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<TaskAnswer> taskAnswers;

}
