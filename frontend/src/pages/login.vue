<template>
  <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
    <div class="login-box">
      <div style="margin-top: 20px;padding-bottom: 20px;">
        <span class="login-tip" style="color:#67c23a;">登录</span>
      </div>
      <el-form ref="form" :model="user" label-width="80px">
        <el-form-item label="账号">
            <el-input v-model="user.account" placeholder="输入账号"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input type="password" v-model="user.password"placeholder="输入密码" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="checked">自动登录</el-checkbox>
          <router-link :to="{ name: 'forgetpwd'}"><span class="more-right">忘记密码</span></router-link>
        </el-form-item>
        <el-form-item>
             <el-button type="primary" @click="onSubmit(user)">登录</el-button>
          <router-link :to="{ name: 'register' }">
            <el-button>注册</el-button>
          </router-link>
        </el-form-item>
      </el-form>
      {{ islogin }}
    </div>
  </el-col>
</template>

<script >
  export default {
    data () {
      return {
        user: {
          account: '15900610143',
          password: '123456'
        },
        checked: false,
        islogin: this.$store.state.islogin
      }
    },
    methods: {
      onSubmit () {
        var result = this.$store.dispatch('login', {
          phone: this.user.account,
          password: this.user.password
        })
        if (result) {
          this.$router.push('/index')
        }
      }
    }
  }
</script>
<style>
  .login-tip{
    font-size: 20px;
    clolr:#67c23a;
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
  .el-button--primary{
    background-color: #67c23a;
    float: left;
    margin-left: 10%;
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
