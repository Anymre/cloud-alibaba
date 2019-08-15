<template>
    <div class="app">
        <template v-for="(i,j) in life">
            <row v-bind:key="j">
                <template v-for="(c,x) in i">
                    <Button class="fig" :class=" c.now?'info':''" v-bind:key="x" @click="remote_flip(j,x)"></Button>
                </template>
            </row>
        </template>
        <row>
            <Button type="success" @click="remote_next">Next</Button>
            <Button type="warning" @click="init">Clear</Button>
            <Button type="warning" @click="remote_start">Start</Button>
            <Button loading shape="circle" v-if="loading"></Button>
        </row>
    </div>
</template>

<script>
    import Vue from 'vue'

    export default {
        name: 'grid',
        data() {
            return {
                life: [],
                loading: false,
                scale: 24,
                off: 0,
                width: 36,
                height: 18,
                speed: 100,
                timer: null
            }
        },
        created: function () {
            this.init()
        },
        methods: {
            init() {
                var that = this
                this.$axios.get("/api/init/init").then(function (r) {
                    that.life = r.data
                    that.scale = that.life.length
                    that.width = that.life[0].length
                    that.height = that.life.length
                }).catch(that.initLocal)
            },
            remote_next() {
                var that = this
                this.axios.get("/api/evolution/evolution").then(function (r) {
                    that.life = r.data
                })
            },
            remote_start() {
                this.loading=!this.loading
                if (this.loading) {
                    this.timer=setInterval(this.remote_next, this.speed)
                }else{
                    clearInterval(this.timer)
                }},
            initLocal() {
                let scale = this.scale;
                let final = new Array(scale);
                for (let i = 0; i < this.height; i++) {
                    let col = new Array(this.width);
                    for (let j = 0; j < this.width; j++) {
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
            remote_flip(x, y) {
                this.axios.get("/api/inevitable/storm/" + x + "/" + y)
            },
            next() {
                for (let i = 1; i < this.height - 1; i++) {
                    for (let j = 1; j < this.width - 1; j++) {
                        this.cell(i, j)
                    }
                }
                this.update()
            },
            cell(x, y) {
                let around = 0;
                for (let i = 0; i < 3; i++) {
                    for (let j = 0; j < 3; j++) {
                        if (x > 0 && x + 1 < this.height) {
                            if (y > 0 && y + 1 < this.width) {
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
                for (let x = 0; x < this.height; x++) {
                    for (let y = 0; y < this.width; y++) {
                        this.life[x][y].now = this.life[x][y].next
                    }
                }
                Vue.set(this.life, this.life)
            }
            ,
            start() {
                setInterval(this.next, 100);
            },

        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .fig {
        width: 20px;
        height: 20px;
    }

    .info {
        width: 20px;
        height: 20px;
        background: red;
    }
</style>
