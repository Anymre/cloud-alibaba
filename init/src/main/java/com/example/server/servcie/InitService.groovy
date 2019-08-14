package com.example.server.servcie

import com.example.server.strategy.Strategy

interface InitService {
    String perform(Strategy strategy)
}