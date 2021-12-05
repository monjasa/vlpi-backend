package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;
import org.monjasa.vlpi.service.ExerciseService;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public ExerciseDto getById(Long exerciseId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ExerciseListItemDto> getAllByModuleId(Long moduleId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PersistableDto create(ExerciseRequest request) {
        throw new UnsupportedOperationException();
    }
}
