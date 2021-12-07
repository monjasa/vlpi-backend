package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.dto.UserAccountDto;
import org.monjasa.vlpi.security.dto.request.RegistrationRequest;
import org.monjasa.vlpi.domain.UserAccount;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    @Mapping(target = "email", source = "username")
    UserAccount toUserAccount(RegistrationRequest request);

    UserAccountDto toDto(UserAccount userAccount);

}
