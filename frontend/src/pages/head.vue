<template>
    <div id = "head">
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        :router="true"
        active-text-color="#ffd04b">
        <div class="blog-name"
        style="
          float: left;text-align: center;
          height: 100%;
          margin-left: 200px;
          margin-top: 15px;
          color: rgb(255, 208, 75);
          font-size: 22px;">
          <span>
            {{ title }}
          </span>
        </div>
        <el-menu-item class="mar-lef" index="/index">首页</el-menu-item>
        <el-menu-item class="mar-lef" index="/blog">关于本站</el-menu-item>
        <el-menu-item class="mar-lef" index="3">留言墙</el-menu-item>
        <!--<div class="login-regist">-->
          <!--<div v-if="!islogin">-->
            <!--<router-link :to="{ name: 'login' }">登录</router-link>-->
            <!--<router-link :to="{ name: 'register' }">-->
            <!--<span style="margin-left: 20px;">注册</span>-->
            <!--</router-link>-->
           <!--</div>-->
          <!--<div v-else="islogin">-->
            <!--<img class="head-img" src="http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com/person/img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20171208103122.jpg"/>-->
            <!--<span style="float: right;margin-top: 10px;margin-left: 10px;"> <a href="#">苏雨丶</a></span>-->
          <!--</div>-->
        <!--</div>-->
        <div style="margin-top: 15px;float: left;margin-left: 360px">
          <el-input placeholder="请输入内容"  class="input-with-select">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div>
      </el-menu>
    </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data () {
      return {
        islogin: this.$store.state.islogin,
        activeIndex: this.$store.state.index,
        title: '苏雨个人博客'
      }
    },
    methods: {
      handleSelect (key) {
        this.$store.dispatch('changeHead', { index: key })
      }
    }
  }
</script>
<style>
  .login-regist {
    float: right;
    margin-top: 18px;
    height: 100%;
    margin-right:7%;
  }
  .mar-lef {
    position: relative;
    line-height: 50px;
    padding: 0 10px;
  }
  a {
    text-decoration: none;
  }
  .head-img{
   width: 35px;
    height: 35px;
    border-radius: 17px;
  }
  #head {
  }
  mybtn {
    width: 6%;
    height: 40px;
    float: left;
  }
  .el-menu--horizontal .el-menu-item {
    margin-left: 3%;
  }
  body{
    margin: 0px;
  }
  .el-input__inner {
    height: 30px;
  }
  .el-input__icon {
    margin-top: -5px;
  }
  .el-menu--horizontal .el-menu-item {
    height: 50px;
  }
  . blog-name {
    float: left;text-align: center;
    height: 100%;
    margin-left: 150px;
    margin-top: 10px;
    color: orange;
    font-size: 30px;
  }
  .am-topbar-brand {
    margin: 0;
    padding: 0 10px;
    float: left;
    font-size: 1.8rem;
    height: 50px;
    line-height: 50px;
  }
</style>
