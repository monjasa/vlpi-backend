package org.monjasa.vlpi.security.service;

import org.monjasa.vlpi.security.dto.AccessTokenDto;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.monjasa.vlpi.security.dto.request.AuthenticationRequest;

public interface AuthenticationService {

    AccessTokenDto authenticate(AuthenticationRequest request);

    AccessTokenDto register(RegistrationRequest request);

}
