<template>
    <div id="app">
        <grid id="grid"/>
    </div>
</template>

<script>
    import grid from "./components/grid"

    export default {
        name: 'app',
        components: {grid},
        data() {
            return {}
        },
        created: function () {
        },
    }
</script>

<style>
    #app {
        text-align:center;
        margin:0 auto;
    }
    #grid{
        margin-top: 5%;
    }
</style>
