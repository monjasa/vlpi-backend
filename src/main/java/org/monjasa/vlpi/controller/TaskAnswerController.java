package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.service.TaskAnswerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/task-answer")
@RequiredArgsConstructor
public class TaskAnswerController {

    private final TaskAnswerService taskAnswerService;

    @PostMapping
    public TaskAnswerDto createTaskAnswer(@RequestBody TaskAnswerRequest taskAnswerRequest) {
        log.info("Creating task answer for exercise answer with id: {}", taskAnswerRequest.getExerciseAnswerId());
        return taskAnswerService.create(taskAnswerRequest);
    }
}
