<template>
  <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
    <div class="login-box">
      <div style="margin-top: 20px;padding-bottom: 20px;">
        <span class="login-tip" style="color:#67c23a;">用户注册</span>
      </div>
      <el-form ref="form" :model="user" label-width="80px">
        <el-form-item label="账号">
          <el-input v-model="user.account" placeholder="输入账号"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="user.password"placeholder="输入密码" ></el-input>
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input v-model="user.repassword"placeholder="再次输入密码" ></el-input>
        </el-form-item>
        <el-form-item>
          <router-link :to="{ name: 'index' }">
             <el-button  @click="onSubmit">注册</el-button>
          </router-link>
        </el-form-item>
      </el-form>
    </div>
  </el-col>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data () {
      return {
        user: {
          account: '',
          password: '',
          repassword: ''
        }
      }
    }
  }
</script>

<style scoped>
  .login-tip{
    font-size: 20px;
    clolr:#67c23a;
  }
  .el-button {
   float: right;
    margin-right: 50px;
    background-color: #67c23a;
    color: white;
  }
  .login-box{
    text-align: center;
    border: 1px solid #d5dce5;
    border-radius: 20px;
    width: 80%;
    margin: 10%;
  }
  .el-input{
    margin-right: 20%;
    width: 90%;
  }
  .el-form-item__content{
    text-align: center;
  }
  .el-checkbox{
    float: left;
    margin-left: 10%;
  }
  a{
    text-decoration: none;
  }
  .router-link-active {
    float: right;
    margin-right: 20%;
  }
</style>
