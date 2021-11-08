package org.monjasa.vpli.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.vpli.domain.MainUser;
import org.monjasa.vpli.dto.MainUserDto;
import org.monjasa.vpli.dto.MainUserRequest;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    MainUser toEntity(MainUserRequest request);

    MainUserDto toNameDto(MainUser mainUser);

}
