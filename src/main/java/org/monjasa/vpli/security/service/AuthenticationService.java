package org.monjasa.vpli.security.service;

import org.monjasa.vpli.security.dto.AccessTokenDto;
import org.monjasa.vpli.security.dto.request.AuthenticationRequest;
import org.monjasa.vpli.security.dto.request.RegistrationRequest;

public interface AuthenticationService {

    AccessTokenDto authenticate(AuthenticationRequest request);

    AccessTokenDto register(RegistrationRequest request);

}
