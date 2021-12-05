package org.monjasa.vpli.security.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vpli.domain.UserAccount;
import org.monjasa.vpli.security.domain.PrincipalUserDetails;

@Mapper(componentModel = "spring", uses = GrantedAuthorityMapper.class)
public interface UserDetailsMapper {

    @Mapping(target = "username", source = "email")
    @Mapping(target = "authorities", source = "roles")
    PrincipalUserDetails toPrincipalUserDetails(UserAccount userAccount);

}
