package com.example.server.servcie

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "inevitable", fallback = InevitableServiceFallback.class)
interface InevitableService {
    @GetMapping("/inevitable")
    void inevitable()
}