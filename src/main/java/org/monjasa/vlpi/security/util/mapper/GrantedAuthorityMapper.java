package org.monjasa.vlpi.security.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.vlpi.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Mapper(componentModel = "spring")
public interface GrantedAuthorityMapper {

    @Mapping(target = "role", source = "name")
    SimpleGrantedAuthority toSimpleGrantedAuthority(Role role);

}
