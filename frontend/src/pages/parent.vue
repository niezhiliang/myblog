<template>
  <div>
    <son  v-on:child-say="listenToMyBoy"></son>
    <p>Do you like me? {{childWords}}</p>
  </div>
</template>

<script>
  import son from '@/pages/son'
  export default {
    data () {
      return {
        childWords: ''
      }
    } ,
    methods: {
      listenToMyBoy: function (somedata){
        this.childWords = somedata
      }
    },
    components: { son }
  }
</script>
