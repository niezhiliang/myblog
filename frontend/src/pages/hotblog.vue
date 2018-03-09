<template>
  <div>
    <el-card class="box-card add-padding" :key="123112312">
      <div slot="header" class="clearfix">
        <span>热门排行</span>
      </div>
      <div v-for="blog in bloghot"  class="text item" style="cursor:pointer">
        <Icon type="ios-infinite-outline"></Icon>
        <router-link
          :to="{path:'blog',query: {bid: blog.id}}">{{ blog.title  }}</router-link>
        <div style="float: right;margin-right: 30px">
          <b>阅读:</b><i>{{ blog.readcount }}</i>
        </div>
      </div>
    </el-card >
  </div>
</template>

<script>
  import request from '@/components/request'

  export default {
    data() {
      return {
        bloghot: []
      }
    },
    created () {
      this.hotblog()
    },
    mounted () {
    },
    methods: {
      hotblog () {
        request.post('/blog/hotblog').then((res) => {
          if (res.data.code === 20) {
          this.bloghot = res.data.content
        }
      })
      }
    }
  }
</script>

<style scoped>
  .box-card {
    background: #FFF;
    padding: 0 2rem;
    margin-top: 16px;
  }
  .add-padding {
    padding: 10px 15px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
</style>
