package org.monjasa.vlpi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.monjasa.vlpi.dto.ModuleListItemDto;
import org.monjasa.vlpi.service.ModuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/module")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping("/all")
    public List<ModuleListItemDto> getAllModules() {
        log.info("Getting all modules");
        return moduleService.getAll();
    }
}
