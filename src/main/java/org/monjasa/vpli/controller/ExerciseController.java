package org.monjasa.vpli.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.ExerciseDto;
import org.monjasa.vpli.dto.ExerciseListItemDto;
import org.monjasa.vpli.dto.common.PersistableDto;
import org.monjasa.vpli.dto.request.ExerciseRequest;
import org.monjasa.vpli.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/{exerciseId}")
    public ExerciseDto getById(@PathVariable Long exerciseId) {
        return exerciseService.getById(exerciseId);
    }

    @GetMapping
    public List<ExerciseListItemDto> getAllByModuleId(@RequestParam Long moduleId) {
        return exerciseService.getAllByModuleId(moduleId);
    }

    @PostMapping
    public PersistableDto create(@RequestBody ExerciseRequest request) {
        return exerciseService.create(request);
    }
}
