package com.example.server.strategy

import com.example.server.servcie.InitServiceImpl


interface Strategy {
    void perform(List<List<InitServiceImpl.State>> list)
}