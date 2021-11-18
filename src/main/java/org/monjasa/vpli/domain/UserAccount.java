package org.monjasa.vpli.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private Boolean enabled;

    private String firstName;

    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "main_user_role",
            joinColumns = @JoinColumn(name = "main_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
