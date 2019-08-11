package com.example.discovery;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
    @RestController
    public class EchoController {
        @Value("${server.port}")
        private String port;
        @GetMapping(value = "/echo/{string}")
        @SentinelResource("/echo/{string}")
        public String echo(@PathVariable String string) throws InterruptedException {
            return "Hello Nacos Discovery " + string + " i am from port " + port;
        }
    }

}
