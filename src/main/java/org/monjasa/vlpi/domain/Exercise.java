package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.SoftDeletedEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Exercise extends SoftDeletedEntity {

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;

    @OneToMany(mappedBy = "exercise", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Task> tasks;

}
