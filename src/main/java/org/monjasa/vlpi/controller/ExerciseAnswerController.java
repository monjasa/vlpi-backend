package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.service.ExerciseAnswerService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/exercise-answer")
@RequiredArgsConstructor
public class ExerciseAnswerController {

    private final ExerciseAnswerService exerciseAnswerService;

    @PostMapping
    public PersistableDto createExerciseAnswer(@RequestBody ExerciseAnswerRequest exerciseAnswerRequest) {
        log.info("Creating exercise answer");
        return exerciseAnswerService.create(exerciseAnswerRequest);
    }

    @PostMapping("/{exerciseAnswerId}/task-answer")
    public TaskAnswerDto createTaskAnswerByExerciseAnswerId(
            @PathVariable Long exerciseAnswerId,
            @RequestBody TaskAnswerRequest taskAnswerRequest) {
        log.info("Creating task answer for exercise answer with id: {}", exerciseAnswerId);
        return exerciseAnswerService.createTaskAnswerByExerciseAnswerId(exerciseAnswerId, taskAnswerRequest);
    }
}
