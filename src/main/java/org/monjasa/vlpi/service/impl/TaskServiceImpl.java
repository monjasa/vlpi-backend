package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.dto.SolutionBlockDto;
import org.monjasa.vlpi.dto.TaskDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;
import org.monjasa.vlpi.exception.NotFoundException;
import org.monjasa.vlpi.repository.SolutionBlockRepository;
import org.monjasa.vlpi.repository.TaskRepository;
import org.monjasa.vlpi.service.TaskService;
import org.monjasa.vlpi.util.mapper.SolutionBlockMapper;
import org.monjasa.vlpi.util.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final SolutionBlockRepository solutionBlockRepository;

    private final TaskMapper taskMapper;

    private final SolutionBlockMapper solutionBlockMapper;

    @Override
    public List<SolutionBlockDto> getSolution(Long taskId) {
        return solutionBlockRepository.findAllForSolutionByTaskId(taskId)
                .stream()
                .map(solutionBlockMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllByExerciseId(Long exerciseId) {
        return taskRepository.findFetchingSolutionBlocksByExerciseId(exerciseId)
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersistableDto create(TaskRequest taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        return taskMapper.toPersistableDto(taskRepository.save(task));
    }

    @Override
    public void deleteById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(NotFoundException::new);

        taskRepository.delete(task);
    }
}
