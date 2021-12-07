package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.dto.TaskDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;
import org.monjasa.vlpi.repository.TaskRepository;
import org.monjasa.vlpi.service.TaskService;
import org.monjasa.vlpi.util.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllByExerciseId(Long exerciseId) {
        return taskRepository.findFetchingSolutionBlocksByExerciseId(exerciseId)
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersistableDto create(Exercise exercise, TaskRequest taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        task.setExercise(exercise);
        return taskMapper.toPersistableDto(taskRepository.save(task));
    }
}