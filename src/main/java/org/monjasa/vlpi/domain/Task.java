package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Task extends AuditableEntity {

    private String question;

    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @OneToMany(mappedBy = "task", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<SolutionBlock> solutionBlocks;

}
