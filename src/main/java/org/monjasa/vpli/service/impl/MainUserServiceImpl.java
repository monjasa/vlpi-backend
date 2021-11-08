package org.monjasa.vpli.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.domain.MainUser;
import org.monjasa.vpli.dto.request.MainUserRequest;
import org.monjasa.vpli.dto.MainUserDto;
import org.monjasa.vpli.repository.MainUserRepository;
import org.monjasa.vpli.service.MainUserService;
import org.monjasa.vpli.util.mapper.MainUserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainUserServiceImpl implements MainUserService {

    private final MainUserRepository mainUserRepository;

    private final MainUserMapper mainUserMapper;

    @Override
    public MainUserDto create(MainUserRequest request) {
        MainUser mainUser = mainUserRepository.save(mainUserMapper.toEntity(request));
        return mainUserMapper.toNameDto(mainUser);
    }
}
