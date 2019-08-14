package com.example.server

import com.example.server.servcie.InitService
import com.example.server.strategy.TumblerStrategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InitController {
    @Autowired
    InitService initService;

    @GetMapping("/init")
    init() {
        return initService.perform(new TumblerStrategy())
    }
}
