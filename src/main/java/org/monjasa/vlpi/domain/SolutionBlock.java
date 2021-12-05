package org.monjasa.vlpi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SolutionBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

}
