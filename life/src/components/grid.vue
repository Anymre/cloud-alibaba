<template>
    <div class="app">
        <template v-for="(i,j) in life">
            <row v-bind:key="j">
                <template v-for="(c,x) in i">
                    <!--<Button :type="c?'info':''" v-bind:key="x"></Button>-->
                    <Button class="fig" :class=" c.now?'info':''" v-bind:key="x" @click="flip(j,x)"></Button>
                </template>
            </row>
        </template>
        <Button type="success" @click="next" ghost>Start</Button>
        <Button type="warning" @click="init" ghost>Clear</Button>
    </div>
</template>

<script>
    import Vue from 'vue'

    export default {
        name: 'grid',
        data() {
            return {
                life: [],
                scale: 9
            }
        },
        created: function () {
            this.init()
        },
        methods: {
            init() {
                let scale = this.scale
                let final = new Array()
                for (let i = 0; i < scale; i++) {
                    let col = new Array(scale).fill({now: 0, next: 0})
                    final[i] = col
                }
                this.life = final
            },
            flip(x, y) {
                if (this.life[x][y].now === 0) {
                    Vue.set(this.life[x], y, {now: 1, next: 0})
                } else {
                    Vue.set(this.life[x], y, {now: 0, next: 0})
                }
            },
            next() {
                for (let i = 0; i < 8; i++) {
                    for (let j = 0; j < 8; j++) {
                        this.cell(i, j)
                    }
                }
                this.update()
            },
            cell(x, y) {
                let around = 0
                for (let i = 0; i < 3; i++) {
                    for (let j = 0; j < 3; j++) {
                        if (x > 0 && x + 1 < this.scale) {
                            if (y > 0 && y + 1 < this.scale) {
                                around += this.life[x - 1 + i][y - 1 + j].now
                            }
                        }
                    }
                }
                around -= this.life[x][y].now
                if (this.life[x][y].now === 1) {
                    if (around <= 1)
                        this.life[x][y].next = 0
                    if (around >= 41)
                        this.life[x][y].next = 0
                    if (around === 2 || around === 3)
                        this.life[x][y].next = this.life[x][y].now
                }
                if (this.life[x][y].now === 0) {
                    if (around === 3)
                        this.life[x][y].next = 1
                }
            },
            update() {
                for (let x = 0; x < 8; x++) {
                    for (let y = 0; y < 8; y++) {
                        this.life[x][y].now = this.life[x][y].next
                    }
                }
                Vue.set(this.life, this.life)
            },
            test() {
                this.life[0][1].now = 1
                this.life[0][2].now = 1
                this.life[0][6].now = 1
                this.life[0][7].now = 1

                this.life[1][0].now = 1
                this.life[1][1].now = 1
                this.life[1][3].now = 1
                this.life[1][5].now = 1
                this.life[1][7].now = 1
                this.life[1][8].now = 1

                this.life[2][4].now = 1
                this.life[2][6].now = 1
                this.life[3][4].now = 1
                this.life[3][6].now = 1
                this.life[4][4].now = 1
                this.life[4][6].now = 1

                this.life[5][3].now = 1
                this.life[5][4].now = 1
                this.life[5][6].now = 1
                this.life[5][7].now = 1

                Vue.set(this.life, this.life)
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .fig {
        width: 50px;
        height: 50px;
    }

    .info {
        width: 50px;
        height: 50px;
        background: red;
    }
</style>
