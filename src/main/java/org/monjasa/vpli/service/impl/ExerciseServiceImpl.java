package org.monjasa.vpli.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.ExerciseDto;
import org.monjasa.vpli.dto.ExerciseListItemDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseRequest;
import org.monjasa.vpli.repository.ExerciseRepository;
import org.monjasa.vpli.service.ExerciseService;
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
