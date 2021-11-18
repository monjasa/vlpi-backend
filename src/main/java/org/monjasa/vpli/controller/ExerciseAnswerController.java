package org.monjasa.vpli.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.TaskAnswerResultDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseAnswerRequest;
import org.monjasa.vpli.dto.request.TaskAnswerRequest;
import org.monjasa.vpli.service.ExerciseAnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercise/answer")
@RequiredArgsConstructor
public class ExerciseAnswerController {

    private final ExerciseAnswerService exerciseAnswerService;

    @PostMapping
    public PersistableDto create(@RequestBody ExerciseAnswerRequest request) {
        return exerciseAnswerService.create(request);
    }

    @PostMapping("/{exerciseAnswerId}")
    public TaskAnswerResultDto createTaskAnswer(@PathVariable Long exerciseAnswerId, @RequestBody TaskAnswerRequest request) {
        return exerciseAnswerService.createTaskAnswer(exerciseAnswerId, request);
    }
}
