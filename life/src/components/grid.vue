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
        <Button type="success" @click="next" ghost>Next</Button>
        <Button type="warning" @click="initLocal" ghost>Clear</Button>
        <Button type="warning" @click="start" ghost>Start</Button>
    </div>
</template>

<script>
    import Vue from 'vue'

    export default {
        name: 'grid',
        data() {
            return {
                life: [],
                scale: 12,
                off: 0
            }
        },
        created: function () {
            this.init()
        },
        methods: {
            init() {
                var that = this
                this.$axios.get("/api/init/init").then(function (r) {
                    that.life = r.data.data
                    that.scale = r.data.scale
                })
            },
            initLocal() {
                let scale = this.scale;
                let final = new Array(scale);
                for (let i = 0; i < scale; i++) {
                    let col = new Array(scale);
                    for (let j = 0; j < scale; j++) {
                        col[j] = {now: 0, next: 0}
                    }
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
                for (let i = 1; i < this.scale - 1; i++) {
                    for (let j = 1; j < this.scale - 1; j++) {
                        this.cell(i, j)
                    }
                }
                this.update()
            },
            cell(x, y) {
                let around = 0;
                for (let i = 0; i < 3; i++) {
                    for (let j = 0; j < 3; j++) {
                        if (x > 0 && x + 1 <= this.scale) {
                            if (y > 0 && y + 1 <= this.scale) {
                                around += this.life[x - 1 + i][y - 1 + j].now;
                            }
                        }
                    }
                }
                around -= this.life[x][y].now;
                if (around < 2)
                    this.life[x][y].next = 0;
                if (around > 3)
                    this.life[x][y].next = 0;
                if (around === 2)
                    this.life[x][y].next = this.life[x][y].now;
                if (around === 3)
                    this.life[x][y].next = 1
            }
            ,
            update() {
                for (let x = 0; x < this.scale; x++) {
                    for (let y = 0; y < this.scale; y++) {
                        this.life[x][y].now = this.life[x][y].next
                    }
                }
                Vue.set(this.life, this.life)
            }
            ,
            start() {
                setInterval(this.next, 100);
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .fig {
        width: 30px;
        height: 30px;
    }

    .info {
        width: 30px;
        height: 30px;
        background: red;
    }
</style>
