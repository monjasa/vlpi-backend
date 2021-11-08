package org.monjasa.vpli.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.vpli.dto.MainUserRequest;
import org.monjasa.vpli.dto.MainUserDto;
import org.monjasa.vpli.service.MainUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/main-user")
@RequiredArgsConstructor
public class MainUserController {

    private final MainUserService mainUserService;

    @PostMapping
    public MainUserDto create(@RequestBody MainUserRequest request) {
        return mainUserService.create(request);
    }
}