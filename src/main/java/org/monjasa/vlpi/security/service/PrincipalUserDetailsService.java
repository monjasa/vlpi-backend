package org.monjasa.vlpi.security.service;

import org.monjasa.vlpi.domain.UserAccount;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PrincipalUserDetailsService extends UserDetailsService {

    UserAccount loadAuthenticatedUser();

    UserDetails createUser(RegistrationRequest request);

}
