package com.example.server.servcie

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service

import java.lang.reflect.Type
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class EvolutionServiceImpl implements EvolutionService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper

    @Override
    void perform() {
        String message = stringRedisTemplate.opsForValue().get("aol")
        List<List<Map>> life=objectMapper.readValue(message,List.class)
        for (int i = 0; i < life.size(); i++) {
            for (int j = 0; j < life.size(); j++) {
                cell(life, i, j, life.size())
            }
        }
        stringRedisTemplate.opsForValue().set("aol", objectMapper.writeValueAsString(life))
    }

    void cell(life, x, y, scale) {
        int around = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x > 0 && x + 1 < scale) {
                    if (y > 0 && y + 1 < scale) {
                        around += life[x - 1 + i][y - 1 + j].now
                    }
                }
            }
        }
        around -= life[x][y].now;
        if (around < 2)
            life[x][y].next = 0;
        if (around > 3)
            life[x][y].next = 0;
        if (around == 2)
            life[x][y].next = life[x][y].now;
        if (around == 3)
            life[x][y].next = 1
    }
    class State {
        int now = 0
        int next = 0
    }
}
