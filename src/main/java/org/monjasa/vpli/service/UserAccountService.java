package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.UserAccountDto;
import org.monjasa.vpli.dto.UserAccountListItemDto;
import org.monjasa.vpli.dto.request.UserAccountAuthenticationRequest;
import org.monjasa.vpli.dto.request.UserAccountRegistrationRequest;

import java.util.List;

public interface UserAccountService {

    UserAccountDto getById(Long userAccountId);

    List<UserAccountListItemDto> getAll();

    void register(UserAccountRegistrationRequest request);

    void authenticate(UserAccountAuthenticationRequest request);

}
