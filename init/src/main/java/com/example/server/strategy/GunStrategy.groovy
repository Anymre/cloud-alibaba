package com.example.server.strategy

import com.example.server.servcie.InitServiceImpl


class GunStrategy implements Strategy {
    void perform(List<List<InitServiceImpl.State>> life) {
        int x = (int) (life.size() / 2 - 1)
        int y = (int) (life.get(0).size() / 2 - 1)
        if (life.get(0).size() > 8) {
            life.get(x - 12).get(y - 20).now = 1


            life.get(x - 5).get(y + 5).now = 1
            life.get(x - 5).get(y + 6).now = 1
            life.get(x - 5).get(y + 16).now = 1
            life.get(x - 5).get(y + 17).now = 1

            life.get(x - 4).get(y + 4).now = 1
            life.get(x - 4).get(y + 6).now = 1
            life.get(x - 4).get(y + 16).now = 1
            life.get(x - 4).get(y + 17).now = 1

            life.get(x - 3).get(y - 18).now = 1
            life.get(x - 3).get(y - 17).now = 1
            life.get(x - 3).get(y - 9).now = 1
            life.get(x - 3).get(y - 8).now = 1
            life.get(x - 3).get(y + 4).now = 1
            life.get(x - 3).get(y + 5).now = 1

            life.get(x - 2).get(y - 18).now = 1
            life.get(x - 2).get(y - 17).now = 1
            life.get(x - 2).get(y - 10).now = 1
            life.get(x - 2).get(y - 8).now = 1

            life.get(x - 1).get(y - 10).now = 1
            life.get(x - 1).get(y - 9).now = 1
            life.get(x - 1).get(y - 2).now = 1
            life.get(x - 1).get(y - 1).now = 1

            life.get(x).get(y).now = 1
            life.get(x).get(y - 2).now = 1

            life.get(x + 1).get(y - 2).now = 1

            life.get(x + 2).get(y + 17).now = 1
            life.get(x + 2).get(y + 18).now = 1

            life.get(x + 3).get(y + 17).now = 1
            life.get(x + 3).get(y + 19).now = 1

            life.get(x + 4).get(y + 17).now = 1

            life.get(x + 7).get(y + 6).now = 1
            life.get(x + 7).get(y + 7).now = 1
            life.get(x + 7).get(y + 8).now = 1

            life.get(x + 8).get(y + 6).now = 1
            life.get(x + 9).get(y + 7).now = 1


        }
    }
}
