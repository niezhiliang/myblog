<template>
  <div>
    <vheader :activeIndex="1"></vheader>
    <div class="center">
      <!-- 页面左侧模块-->
      <el-container>
        <el-aside width="860px" style="height: 100%">
          <template>
            <el-carousel indicator-position="outside">
              <el-carousel-item v-for="item in 4" :key="item">
              </el-carousel-item>
            </el-carousel>
          </template>
          <!-- 阅读排行榜 -->
          <el-card class="box-card add-padding">
            <div slot="header" class="clearfix">
              <span>热门排行</span>
            </div>
            <div v-for="o in 4" :key="o" class="text item" style="cursor:pointer">
              <Icon type="ios-infinite-outline"></Icon>
              <a href="#"><span>{{'Java多线程运行原理深度挖掘 ' + o }}</span></a>
              <div style="float: right;margin-right: 30px">
                <b>阅读:</b><i>520</i>
              </div>
            </div>
          </el-card>
          <!-- 文章简介卡片 -->
          <el-card class="box-card card-border" style="margin-top: 10px;padding-top: 10px" v-for="i in 5">
            <div style="margin-top: -10px">
              <span class="qing-category">技术</span>
              <i class="el-icon-caret-right icon-size" ></i>
              <a href="#" style="color: cornflowerblue;font-size: 16px">Java多线程运行原理深度挖掘</a>
            </div>
            <div class="qing-list-hint">
              <span><Icon type="person" style="font-size: 13px;color:#01AAED"></Icon> 木槿心 </span>
              <span><Icon type="clock" style="color: darkgoldenrod;"></Icon>&nbsp; 2018-02-09&nbsp;</span>
              <span><Icon type="ios-eye" style="color:#01AAED;font-size: 15px"></Icon>&nbsp;阅读(58)&nbsp;</span>
              <span><Icon type="ios-chatboxes" style="font-size: 13px;color:#67c23a;"></Icon>&nbsp;评论(1)</span>
            </div>
            <p class="qing-list-content">JavaScript学习总结，undefined是全局对象（window）的一个特殊属性，其值是未定义的(当尝试读取不存在的对象属性时会返回 undefined)</p>
            <div class="qing-list-foot">
              <Icon type="ios-pricetags" style="margin-right: 5px"></Icon>
              <span class="am-radius">#前端</span>
              <span class="am-radius">#JS</span>
              <a href="/B20170905221529.html" class="qing-read-more">阅读全文&gt;&gt;</a> </div>
          </el-card>
          <!-- 分页 -->
            <el-pagination
              background
              layout="prev, pager, next"
              prev-text="上一页"
              next-text="下一页"
              :total="60" style="margin-top: 10px;background-color:#fff;padding: 10px">
            </el-pagination>

        </el-aside>
        <!-- 模块之间的间隔-->
        <!--<div style="background-color: #f4f4f4;">-->
          <!--<el-aside width="20px"></el-aside>-->
        <!--</div>-->
        <!-- 页面中间模块-->
        <el-main>
          <div class="top-main">
            <!-- 标签 -->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>文章分类</span>
              </div>
              <div v-for="o in 5" :key="o" style="cursor:pointer">
                <Tag checkable color="blue">标签一</Tag>
                <Tag checkable color="green">标签二</Tag>
                <Tag checkable color="red">标签三</Tag>
                <Tag checkable color="yellow">标签四</Tag>
              </div>
            </el-card>
            <!--最新文章-->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>最新文章</span>
              </div>
              <div v-for="o in 4" :key="o" style="cursor:pointer">
                <div style="margin-top: 8px">
                  <a class="qing-item-link" href="/B20180124164708.html">RocketMQ4.2在纯IPv6环境下使用的问题</a>
                </div>
              </div>
            </el-card>
            <!--标签云-->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>标签云</span>
              </div>
              <div v-for="o in 4" :key="o" style="cursor:pointer">
                <div style="display: block">{{ 标签 +o}}</div>
              </div>
            </el-card>
            <!--联系我-->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>联系我</span>
              </div>
              <div class="qing-panel-body">
                <p class="am-text-left">邮箱：nzlsgg@163.com</p>
                <p class="am-text-left">QQ交流群：1234567890</p>
              </div>
            </el-card>
            <!--友情链接-->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>友情链接</span>
              </div>
              <div v-for="o in 4" :key="o" style="cursor:pointer">
                <div style="margin-top: 8px">
                  <a class="qing-item-link" href="/B20180124164708.html">我的GitHub</a>
                </div>
              </div>
            </el-card>
          </div>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import vheader from '@/pages/head'
  import request from '@/components/request'
  export default {
    name: 'Test',
    data () {
      return {
        lefttop: {
          blogcount: 0,
          comments: 0,
          user: {
            headimage: '',
            id: '',
            username: ''
          },
          visitcount: ''
        },
        blogs: [],
        blogord: [],
        currpage: 1,
        count: 1,
        pages: 1,
        value2: 0
      }
    },
    created () {
      this.islogin = this.$store.state.islogin
      if (this.islogin === false) {
        this.$router.push('/login')
      }
      this.open()
      this.initLab()
      this.initBlog()
      this.initOrder()
      this.initLeftTop()
    },
    mounted () {
    },
    methods: {
      open () {
        this.$message('登录成功')
      },
      initLab () {
        request.post('/label/getlabelsandcount').then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.tags = res.data.content
          }
        })
      },
      initBlog () {
        request.post('/blog/list', this.select).then((res) => {
          if (res.data.code === 20) {
            this.blogs = res.data.content.blogs
            this.currpage = res.data.content.currpage
            this.pages = res.data.content.pages
            this.count = res.data.content.count
          }
        })
      },
      initOrder () {
        request.post('/blog/readorder').then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.blogord = res.data.content
          }
        })
      },
      changePage () {
        console.log(this.select.pageno)
        console.log(this.select.pagesize)
        this.initBlog()
      },
      initLeftTop () {
        request.post('/user/blogleft', {id: 1}).then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.lefttop = res.data.content
          }
        })
      },
      selectkind (lid) {
        this.select.pageno = 1
        this.select.lid = lid
        this.initBlog()
      },
      changestyle () {
        console.log(110)
      }
    },
    components: { vheader }
  }
</script>

<style>
  h1 {
    color: red;
  }
  .el-aside{
    width: 15%;
  }
  body {
    background-color: #f2f2f2;
  }
  .center {
    margin-left: 15%;
    margin-right:15%;
    margin-top: 20px;
    background-color: #fff;
  }
  .top-main {
    width: 96%;
    margin-left: 2%;
    border: 1px solid #eee;
    height: 100px;
  }
  .blog-art-box{
    border: 1px solid #eee;
    width: 96%;
    margin-left: 2%;
    margin-top: 12px;
    height: 12%;
  }
  .blog-title{
    color: #000;
    font-size: 18px;
    margin-left: 20px;
    margin-top: 15px;
  }
  .blog-introduction{
    margin-top: 10px;
    margin-left: 20px;
    font-size: 14px;
    color: #666;
  }
  a:hover{color: #67c23a;}

  .el-pager li.active {
    color: #67c23a;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .text {
    font-size: 13px;
  }

  .item {
    margin-bottom: 8px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    background: #FFF;
    padding: 0 2rem;
    margin-top: 16px;
  }
  .el-aside {
    padding: 20px 20px;
  }
  .el-card__header {
    padding: 18px 20px;
    border-bottom: 1px solid #67c23a;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }
  .card-border {
    border-bottom: none;
  }
  .el-pagination {
    white-space: nowrap;
    padding: 2px 1px;
    color: white;
    font-weight: 700;
    text-align: center;
  }
  .el-pagination.is-background .el-pager li.active {
    background-color: #67c23a;
    color: #fff;
  }
  .el-main {
    background-color: #f2f2f2;
    padding: 0px 0px;
  }
  .el-aside {
    background-color: #f2f2f2;
    height: 1200px;
  }

  #pagehelper {
    height: 56px;
    padding: 8px;
  }
  .add-padding {
    padding: 10px 15px;
  }
  .el-card__body {
    padding: 10px 10px;
  }
  .el-card__header {
    padding: 10px;
  }
  .qing-category{
    color: #fff;
    background-color: #1abc9c;
    padding: 3px 6px;
    font-size: 10px;
    position: relative;
    top: -2px;
    margin-right: 5px;
  }
  .qing-list-hint{
    padding-top: 0.2rem;
    font-size: 10px;
  }
  .qing-list-content {
    padding: 0.2rem 0;
    text-indent: 2em;
    font-size: 14px;
    line-height: 22px;
    color: #777;
  }
  .qing-list-foot {
    font-size: 8px;
    text-align: left;
  }
  .am-radius {
    border-radius: 2px;
  }
  .qing-list-foot a {
    margin: 0.15rem 0.15rem;
    font-size: 10px;
    float: right;
    color: #009688;
  }
  .icon-size{
    color:rgb(26, 188, 156);
    margin-left: -18px;
    font-size: 20px
  }
</style>
