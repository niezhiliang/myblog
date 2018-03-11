<template>
    <div id = "head">
      <Row>
        <i-col :xs="{ span: 24 }" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 24}">
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            :router="true"
            active-text-color="#ffd04b">
            <!--<div class="blog-name"-->
                 <!--style="-->
          <!--float: left;text-align: center;-->
          <!--height: 100%;-->
          <!--margin-left: 200px;-->
          <!--margin-top: 15px;-->
          <!--color: rgb(255, 208, 75);-->
          <!--font-size: 22px;">-->
            <!--</div>-->
          <span style="
                float: left;text-align: center;
                height: 100%;
                margin: 0 auto;
                margin-top: 15px;
                color: rgb(255, 208, 75);
                font-size: 22px;">
            {{ title }}
          </span>

            <el-menu-item class="mar-lef" index="/">首页</el-menu-item>
            <el-menu-item class="mar-lef" index="/blog">关于本站</el-menu-item>
            <el-menu-item class="mar-lef" index="3">留言墙</el-menu-item>
          </el-menu>
        </i-col>
      </Row>
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
  }
  .mar-lef {
    position: relative;
    line-height: 50px;
    padding: 0 10px;
  }
  a {
    text-decoration: none;
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
