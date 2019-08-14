package com.example.server.servcie

import com.example.server.strategy.Strategy
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service

@Service
@RefreshScope
class InitServiceImpl implements InitService {
    @Value("\${life.scale}")
    int scale

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    String perform(Strategy strategy) {
        def world = createWorld()
        strategy.perform(world)
        def res = new HashMap();
        res.put("data", world)
        res.put("scale", this.scale)
        String message = objectMapper.writeValueAsString(res)
        stringRedisTemplate.convertAndSend("aol", message)
        return message
    }

    List createWorld() {
        List<List<State>> world = new ArrayList()
        for (int i = 0; i < scale; i++) {
            List<State> col = new ArrayList()
            for (int j = 0; j < scale; j++) {
                col.add(new State())
            }
            world.add(col)
        }
        return world
    }

    class State {
        int now = 0
        int next = 0
    }

}