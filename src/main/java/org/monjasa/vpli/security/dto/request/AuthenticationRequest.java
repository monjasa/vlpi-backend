package org.monjasa.vpli.security.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class AuthenticationRequest {

    private String username;

    private String password;

}
