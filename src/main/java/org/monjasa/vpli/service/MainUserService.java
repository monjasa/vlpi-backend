package org.monjasa.vpli.service;

import org.monjasa.vpli.dto.request.MainUserRequest;
import org.monjasa.vpli.dto.MainUserDto;

public interface MainUserService {

    MainUserDto create(MainUserRequest request);

}
