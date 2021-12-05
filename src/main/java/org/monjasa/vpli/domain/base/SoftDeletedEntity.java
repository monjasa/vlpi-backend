package org.monjasa.vpli.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class SoftDeletedEntity<PK extends Serializable> extends AuditableEntity<PK> {

    protected Boolean isDeleted = false;

}
