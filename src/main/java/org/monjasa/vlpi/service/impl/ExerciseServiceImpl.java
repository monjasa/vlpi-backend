package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;
import org.monjasa.vlpi.dto.request.TaskRequest;
import org.monjasa.vlpi.exception.NotFoundException;
import org.monjasa.vlpi.repository.ExerciseRepository;
import org.monjasa.vlpi.service.ExerciseService;
import org.monjasa.vlpi.service.TaskService;
import org.monjasa.vlpi.util.mapper.ExerciseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final TaskService taskService;

    private final ExerciseRepository exerciseRepository;

    private final ExerciseMapper exerciseMapper;

    @Override
    public ExerciseDto getById(Long exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(NotFoundException::new);

        ExerciseDto exerciseDto = exerciseMapper.toDto(exercise);
        exerciseDto.setTasks(taskService.getAllByExerciseId(exerciseId));

        return exerciseDto;
    }

    @Override
    public List<ExerciseListItemDto> getAllByModuleId(Long moduleId) {
        return exerciseRepository.findAllByModuleId(moduleId)
                .stream()
                .map(exerciseMapper::toListItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersistableDto create(ExerciseRequest exerciseRequest) {
        Exercise exercise = exerciseRepository.save(exerciseMapper.toEntity(exerciseRequest));
        return exerciseMapper.toPersistableDto(exercise);
    }

    @Override
    public PersistableDto createTaskByExerciseId(Long exerciseId, TaskRequest taskRequest) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(NotFoundException::new);
        return taskService.create(exercise, taskRequest);
    }
}
