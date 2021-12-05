package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.vlpi.domain.base.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@Entity
public class Role extends PersistableEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserAccount> userAccounts;

}
