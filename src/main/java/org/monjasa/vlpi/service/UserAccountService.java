package org.monjasa.vlpi.service;

import org.monjasa.vlpi.dto.UserAccountDto;
import org.monjasa.vlpi.dto.UserAccountListItemDto;

import java.util.List;

public interface UserAccountService {

    UserAccountDto getById(Long userAccountId);

    List<UserAccountListItemDto> getAll();

}
