<template>
    <div class="app">
      <template v-for="(i,j) in life">
        <row v-bind:key="j">
          <template v-for="(c,x) in i">
            <Button :type="c?'info':''" v-bind:key="x"/>
          </template>
        </row>
      </template>
    </div>
</template>

<script>
    export default {
        name: 'grid',
        data() {
            return {
                life: [
                    [0, 0, 0],
                    [0, 0, 0],
                    [0, 0, 0],
                ]
            }
        },
        created: function () {
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    button {
        width: 50px;
        height: 50px;
    }
</style>
