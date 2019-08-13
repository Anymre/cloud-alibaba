<template>
    <div id="app">
        <grid id="grid"/>
        <Button type="success" ghost>Start</Button>
        <Button type="warning" ghost>Stop</Button>
    </div>
</template>

<script>
    import grid from "./components/grid"
    export default {
        name: 'app',
        components: {grid},
        data() {
            return {
                color: null,
            }
        },
        created: function () {

        },
    }
</script>

<style>
    #grid {
        position: absolute;
        left: 46%;
        top: 20%;
    }
</style>
