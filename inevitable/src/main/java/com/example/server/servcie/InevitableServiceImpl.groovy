package com.example.server.servcie


import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service

@Service
class InevitableServiceImpl implements InevitableService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper

    @Override
    void perform() {
        String message = stringRedisTemplate.opsForValue().get("aol")
        List<List<Map>> life = objectMapper.readValue(message, List.class)
        for (int i = 0; i < life.size(); i++) {
            for (int j = 0; j < life.size(); j++) {
                life[i][j].now = life[i][j].next
            }
        }
        stringRedisTemplate.opsForValue().set("aol", objectMapper.writeValueAsString(life))
    }
}
