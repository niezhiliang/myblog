<template>
  <div id="">
    <el-menu default-active="1-4-1" class="el-menu-vertical-demo"
             background-color="#4B4B4B" text-color="#fff"
             active-text-color="#FFFF00"
             @open="handleOpen" @close="handleClose" :collapse="isCollapse">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span slot="title">博客管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">发布</el-menu-item>
          <el-menu-item index="1-2">查看</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span slot="title">数据查看</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">用户</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-setting"></i>
          <span slot="title">导航三</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>
<style>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width:100%;
    min-height: 100%;
  }
  #app {
    height: 100%;
  }
</style>

<script>
//  export default {
//    data() {
//      return {
//        isCollapse: false
//      };
//    },
//    methods: {
//      handleOpen(key, keyPath) {
//        console.log(key, keyPath);
//      },
//      handleClose(key, keyPath) {
//        console.log(key, keyPath);
//      }
//    }
//  }
</script>
