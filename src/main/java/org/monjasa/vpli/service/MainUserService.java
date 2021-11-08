package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.MainUserRequest;
import org.monjasa.vpli.dto.MainUserDto;

public interface MainUserService {

    MainUserDto create(MainUserRequest request);

}
