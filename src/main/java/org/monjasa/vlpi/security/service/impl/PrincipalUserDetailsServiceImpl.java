package org.monjasa.vlpi.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.monjasa.vlpi.security.service.PrincipalUserDetailsService;
import org.monjasa.vlpi.domain.Role;
import org.monjasa.vlpi.domain.UserAccount;
import org.monjasa.vlpi.repository.RoleRepository;
import org.monjasa.vlpi.repository.UserAccountRepository;
import org.monjasa.vlpi.security.util.mapper.UserDetailsMapper;
import org.monjasa.vlpi.util.mapper.UserAccountMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PrincipalUserDetailsServiceImpl implements PrincipalUserDetailsService {

    public static final String DEFAULT_ROLE_NAME = "ROLE_STUDENT";

    private final UserAccountRepository userAccountRepository;

    private final RoleRepository roleRepository;

    private final UserDetailsMapper userDetailsMapper;

    private final UserAccountMapper userAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User account not found"));
        return userDetailsMapper.toPrincipalUserDetails(userAccount);
    }

    @Override
    public UserDetails loadAuthenticatedUser() {
        return (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @Override
    public UserDetails createUser(RegistrationRequest request) {
        if (userAccountRepository.existsByEmail(request.getUsername())) {
            throw new IllegalArgumentException();
        }

        UserAccount userAccount = userAccountMapper.toUserAccount(request);
        userAccount.setRoles(getDefaultRoles());

        return userDetailsMapper.toPrincipalUserDetails(userAccountRepository.save(userAccount));
    }

    private Set<Role> getDefaultRoles() {
        return roleRepository.findByName(DEFAULT_ROLE_NAME)
                .map(Set::of)
                .orElse(Collections.emptySet());
    }
}
