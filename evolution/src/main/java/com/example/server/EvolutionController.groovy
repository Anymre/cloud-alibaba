package com.example.server

import com.example.server.config.Speed
import com.example.server.servcie.EvolutionService
import com.example.server.servcie.InevitableService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
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

    @Autowired
    ObjectMapper objectMapper


    @GetMapping("/evolution")
    String redis() {
        evolutionService.perform()
        inevitableService.inevitable()
        return stringRedisTemplate.opsForValue().get("aol")
    }

    @MessageMapping("/evolution")
    @SendTo("/topic/evolutions")
    String websocket(Speed speed) {
        return redis()
    }
}
