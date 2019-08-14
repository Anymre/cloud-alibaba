package com.example.server.servcie;

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EvolutionServiceImplTest {
    @Autowired
    EvolutionService evolutionService;

    @Test
    void perform() {
        evolutionService.perform();
    }
}