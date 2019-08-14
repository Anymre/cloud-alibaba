package com.example.server

import com.example.server.servcie.InitService
import org.junit.Test
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner.class)
@SpringBootTest
class InitServiceImplTest {
    @Autowired
    InitService initService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void createWorld() {
        initService.perform();
    }
}