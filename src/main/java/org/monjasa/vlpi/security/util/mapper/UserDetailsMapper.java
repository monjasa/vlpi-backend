package org.monjasa.vlpi.security.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.UserAccount;
import org.monjasa.vlpi.security.domain.PrincipalUserDetails;

@Mapper(componentModel = "spring", uses = GrantedAuthorityMapper.class)
public interface UserDetailsMapper {

    @Mapping(target = "username", source = "email")
    @Mapping(target = "authorities", source = "roles")
    PrincipalUserDetails toPrincipalUserDetails(UserAccount userAccount);

}
