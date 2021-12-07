package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.UserAccount;
import org.monjasa.vlpi.dto.UserAccountDto;
import org.monjasa.vlpi.dto.UserAccountListItemDto;
import org.monjasa.vlpi.repository.UserAccountRepository;
import org.monjasa.vlpi.security.service.PrincipalUserDetailsService;
import org.monjasa.vlpi.service.UserAccountService;
import org.monjasa.vlpi.util.mapper.UserAccountMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final PrincipalUserDetailsService principalUserDetailsService;

    private final UserAccountRepository userAccountRepository;

    private final UserAccountMapper userAccountMapper;

    @Override
    public UserAccountDto getCurrent() {
        UserDetails userDetails = principalUserDetailsService.loadAuthenticatedUser();
        UserAccount userAccount = userAccountRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User account not found"));
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public UserAccountDto getById(Long userAccountId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserAccountListItemDto> getAll() {
        throw new UnsupportedOperationException();
    }
}
