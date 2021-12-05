package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.AuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Module extends AuditableEntity {

    private String name;

    private String description;

    @OneToMany(mappedBy = "module", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Exercise> exercises;

}
