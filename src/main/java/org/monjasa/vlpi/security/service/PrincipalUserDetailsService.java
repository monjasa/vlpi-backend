package org.monjasa.vlpi.security.service;

import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PrincipalUserDetailsService extends UserDetailsService {

    UserDetails loadAuthenticatedUser();

    UserDetails createUser(RegistrationRequest request);

}
