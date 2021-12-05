package org.monjasa.vpli.security.service;

import org.monjasa.vpli.security.dto.request.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PrincipalUserDetailsService extends UserDetailsService {

    UserDetails createUser(RegistrationRequest request);

}
