package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.UserAccountDto;
import org.monjasa.vpli.dto.UserAccountListItemDto;

import java.util.List;

public interface UserAccountService {

    UserAccountDto getById(Long userAccountId);

    List<UserAccountListItemDto> getAll();

}
