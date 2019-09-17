package com.example.server

import com.example.server.servcie.EvolutionService
import com.example.server.servcie.InevitableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class EvolutionController {
    @Autowired
    EvolutionService evolutionService

    @Autowired
    StringRedisTemplate stringRedisTemplate

    @Autowired
    InevitableService inevitableService



    @GetMapping("/evolution")
    String redis() {
        evolutionService.perform()
        inevitableService.inevitable()
        return stringRedisTemplate.opsForValue().get("aol")
    }
}
