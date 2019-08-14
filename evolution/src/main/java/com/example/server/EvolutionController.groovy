package com.example.server

import com.example.server.servcie.EvolutionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EvolutionController {
    @Autowired
    EvolutionService evolutionService;

    @GetMapping("/evolution")
    init() {
        return evolutionService.perform()
    }
}
