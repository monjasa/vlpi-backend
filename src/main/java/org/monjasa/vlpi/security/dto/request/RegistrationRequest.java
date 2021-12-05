package org.monjasa.vlpi.security.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

}
