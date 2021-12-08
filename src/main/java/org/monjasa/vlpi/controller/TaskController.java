package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.SolutionBlockDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;
import org.monjasa.vlpi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{taskId}/solution")
    public List<SolutionBlockDto> getTaskSolution(@PathVariable Long taskId) {
        log.info("Getting task solution by id: {}", taskId);
        return taskService.getSolution(taskId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public PersistableDto createTask(@RequestBody TaskRequest taskRequest) {
        log.info("Creating task for exercise with id: {}", taskRequest.getExerciseId());
        return taskService.create(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable Long taskId) {
        log.info("Deleting task by id: {}", taskId);
        taskService.deleteById(taskId);
    }
}
