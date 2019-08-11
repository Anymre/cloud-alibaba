package com.example.feign;

import org.springframework.stereotype.Component;


@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String message) {
        return "echo fallback";
    }
}

