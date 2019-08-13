package com.example.server;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class TestService {
    @Value("tips")
    String tips;
}
