package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;
import org.monjasa.vlpi.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/{exerciseId}")
    public ExerciseDto getExerciseById(@PathVariable Long exerciseId) {
        log.info("Getting exercise by id: {}", exerciseId);
        return exerciseService.getById(exerciseId);
    }

    @GetMapping("/all")
    public List<ExerciseListItemDto> getAllExercisesByModuleId(@RequestParam Long moduleId) {
        log.info("Getting all exercises by module id: {}", moduleId);
        return exerciseService.getAllByModuleId(moduleId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public PersistableDto createExercise(@RequestBody ExerciseRequest exerciseRequest) {
        log.info("Creating exercise");
        return exerciseService.create(exerciseRequest);
    }

    @DeleteMapping("/{exerciseId}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExerciseById(@PathVariable Long exerciseId) {
        log.info("Deleting exercise by id: {}", exerciseId);
        exerciseService.deleteById(exerciseId);
    }
}
