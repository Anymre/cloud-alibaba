package com.example.server

import com.example.server.servcie.InevitableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InevitableController {
    @Autowired
    InevitableService inevitableService;

    @GetMapping("/inevitable")
    void inevitable() {
       inevitableService.perform()
    }
}
