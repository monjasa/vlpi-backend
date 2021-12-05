package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.dto.ModuleListItemDto;
import org.monjasa.vlpi.repository.ModuleRepository;
import org.monjasa.vlpi.service.ModuleService;
import org.monjasa.vlpi.util.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    private final ModuleMapper moduleMapper;

    @Override
    public List<ModuleListItemDto> getAll() {
        return moduleRepository.findAll()
                .stream()
                .map(moduleMapper::toListItemDto)
                .collect(Collectors.toList());
    }
}
