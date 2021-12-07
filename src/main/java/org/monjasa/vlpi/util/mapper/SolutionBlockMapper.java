package org.monjasa.vlpi.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.vlpi.domain.SolutionBlock;
import org.monjasa.vlpi.dto.request.SolutionBlockRequest;

@Mapper(componentModel = "spring")
public interface SolutionBlockMapper {

    SolutionBlock toEntity(SolutionBlockRequest request);

}
