package org.monjasa.vpli.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vpli.domain.UserAccount;
import org.monjasa.vpli.security.dto.request.RegistrationRequest;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    @Mapping(target = "email", source = "username")
    UserAccount toUserAccount(RegistrationRequest request);

}
