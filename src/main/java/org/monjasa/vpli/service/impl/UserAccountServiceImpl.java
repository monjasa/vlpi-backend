package org.monjasa.vpli.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.UserAccountDto;
import org.monjasa.vpli.dto.UserAccountListItemDto;
import org.monjasa.vpli.dto.request.UserAccountAuthenticationRequest;
import org.monjasa.vpli.dto.request.UserAccountRegistrationRequest;
import org.monjasa.vpli.repository.UserAccountRepository;
import org.monjasa.vpli.service.UserAccountService;
import org.monjasa.vpli.util.mapper.UserAccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    private final UserAccountMapper userAccountMapper;

    @Override
    public UserAccountDto getById(Long userAccountId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserAccountListItemDto> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void register(UserAccountRegistrationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void authenticate(UserAccountAuthenticationRequest request) {
        throw new UnsupportedOperationException();
    }
}
