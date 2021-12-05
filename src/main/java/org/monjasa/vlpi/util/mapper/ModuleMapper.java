package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.vlpi.domain.Module;
import org.monjasa.vlpi.dto.ModuleListItemDto;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleListItemDto toListItemDto(Module module);

}
