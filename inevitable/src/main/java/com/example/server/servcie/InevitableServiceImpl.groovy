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
            for (int j = 0; j < life.get(0).size(); j++) {
                life[i][j].now = life[i][j].next
            }
        }
        stringRedisTemplate.opsForValue().set("aol", objectMapper.writeValueAsString(life))
    }

    @Override
    void storm(Object x, Object y) {
        int i=Integer.valueOf(x)
        int j=Integer.valueOf(y)
        String message = stringRedisTemplate.opsForValue().get("aol")
        List<List<Map>> life = objectMapper.readValue(message, List.class)
        if (life.get(i).get(j).now == 1)
            life.get(i).get(j).now = 0
        else life.get(i).get(j).now = 1
        stringRedisTemplate.opsForValue().set("aol", objectMapper.writeValueAsString(life))
    }
}
