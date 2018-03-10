<template>
  <div>
    <button v-on:click="onClickMe">like!</button>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        somedata: 'like'
      }
    } ,
    methods: {
      onClickMe: function(){
        this.$emit('child-say',this.somedata);
      }
    }
  }
</script>
