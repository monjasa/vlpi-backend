package org.monjasa.vpli.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.vpli.domain.UserAccount;
import org.monjasa.vpli.dto.request.UserAccountRegistrationRequest;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    UserAccount toEntity(UserAccountRegistrationRequest request);

}
