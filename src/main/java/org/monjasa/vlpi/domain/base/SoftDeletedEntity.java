package org.monjasa.vlpi.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class SoftDeletedEntity extends AuditableEntity {

    protected Boolean isDeleted = false;

}
