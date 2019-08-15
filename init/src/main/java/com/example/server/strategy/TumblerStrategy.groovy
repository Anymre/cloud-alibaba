package com.example.server.strategy

import com.example.server.servcie.InitServiceImpl


class TumblerStrategy implements Strategy {
    void perform(List<List<InitServiceImpl.State>> life) {
        int x = (int) (life.size() / 2 - 1)
        int y = (int) (life.get(0).size() / 2 - 1)
        if (life.get(0).size() > 8) {
            life.get(x - 2).get(y - 2).now = 1
            life.get(x - 2).get(y - 1).now = 1
            life.get(x - 2).get(y + 2).now = 1
            life.get(x - 2).get(y + 1).now = 1

            life.get(x - 1).get(y - 2).now = 1
            life.get(x - 1).get(y - 1).now = 1
            life.get(x - 1).get(y + 2).now = 1
            life.get(x - 1).get(y + 1).now = 1

            life.get(x).get(y - 1).now = 1
            life.get(x + 1).get(y - 1).now = 1
            life.get(x + 1).get(y - 3).now = 1
            life.get(x + 2).get(y - 1).now = 1
            life.get(x + 2).get(y - 3).now = 1


            life.get(x).get(y + 1).now = 1
            life.get(x + 1).get(y + 1).now = 1
            life.get(x + 1).get(y + 3).now = 1
            life.get(x + 2).get(y + 1).now = 1
            life.get(x + 2).get(y + 3).now = 1

            life.get(x + 3).get(y - 3).now = 1
            life.get(x + 3).get(y - 2).now = 1
            life.get(x + 3).get(y + 3).now = 1
            life.get(x + 3).get(y + 2).now = 1

        }
    }
}
