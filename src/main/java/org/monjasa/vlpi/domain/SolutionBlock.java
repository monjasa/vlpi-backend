package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SolutionBlock extends AuditableEntity {

    private String text;

    private Integer solutionOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

}
