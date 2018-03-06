<template>
  <div>
    <markdown
      :mdValuesP="msg"
      :fullPageStatusP="false"
      :editStatusP="false"
      :previewStatusP="false"
      :navStatusP="false"
      :icoStatusP="true"
      @childevent="childEventHandler">
    </markdown>
  </div>
</template>

<script>
  import markdown from '../components/markdown'
  export default {
    name: 'index',
    data() {
      return {
        msg: {
          mdValue:'## Vue-markdownEditor'
        }
        //初始化markdown编辑器的内容，通过props传入子组件
      }
    },
    components: {
      markdown // 声明mardown组件
    },
    methods: {
      // 监听事件，接收子组件传过来的数据
      childEventHandler:function(res){
        // res会传回一个data,包含属性mdValue和htmlValue，具体含义请自行翻译
        this.msg=res;
      }
    }
  }
</script>

<style scoped>

</style>
