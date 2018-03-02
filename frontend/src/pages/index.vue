<template>
  <div>
    <vheader :activeIndex="1"></vheader>
    <div class="center">
      <!-- 页面左侧模块-->
      <el-container>
        <el-aside width="860px" style="height: 100%">
          <template>
            <el-carousel>
              <el-carousel-item v-for="img in imgs">
                <img style="width: 100%;height: 100%;display: block;" :src="img.url"></img>
              </el-carousel-item>
            </el-carousel>
          </template>
          <!-- 阅读排行榜 -->
          <el-card class="box-card add-padding">
            <div slot="header" class="clearfix">
              <span>热门排行</span>
            </div>
            <div v-for="blog in bloghot"  class="text item" style="cursor:pointer">
              <Icon type="ios-infinite-outline"></Icon>
              <a href="#"><span>{{ blog.title }}</span></a>
              <div style="float: right;margin-right: 30px">
                <b>阅读:</b><i>{{ blog.readcount }}</i>
              </div>
            </div>
          </el-card>
          <!-- 文章简介卡片 -->
          <el-card class="box-card card-border" style="margin-top: 10px;padding-top: 10px" v-for="b in blogs">
            <div style="margin-top: -10px">
              <span class="qing-category">技术</span>
              <i class="el-icon-caret-right icon-size" ></i>
              <router-link
                :to="{path:'blog',query: {bid: b.blog.id}}" style="color: cornflowerblue;font-size: 16px">{{ b.blog.title  }}</router-link>
            </div>
            <div class="qing-list-hint">
              <span><Icon type="person" style="font-size: 13px;color:#01AAED"></Icon> 木槿心 </span>
              <span><Icon type="clock" style="color: darkgoldenrod;"></Icon>&nbsp; {{ b.blog.createtime | time }}&nbsp;</span>
              <span><Icon type="ios-eye" style="color:#01AAED;font-size: 15px"></Icon>&nbsp;阅读({{ b.blog.readcount }})&nbsp;</span>
              <span><Icon type="ios-chatboxes" style="font-size: 13px;color:#67c23a;"></Icon>&nbsp;评论( {{ b.blog.comment }})</span>
            </div>
            <p class="qing-list-content">{{ b.blog.resume }}</p>
            <div class="qing-list-foot">
              <Icon type="ios-pricetags" style="margin-right: 5px"></Icon>
              <span class="am-radius" v-for="l in b.types">#{{ l }}</span>
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
        <el-main>
          <div class="top-main">
            <!-- 标签 -->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>文章分类</span>
              </div>
              <div v-for="o in labels" :key="o" style="cursor:pointer;display: inline">
                <Tag checkable color="blue">{{ o.labelname}}</Tag>
              </div>
            </el-card>
            <!--最新文章-->
            <el-card class="box-card" style="padding:10px 15px ">
              <div slot="header" class="clearfix">
                <span>最新文章</span>
              </div>
              <div v-for="o in blognew" :key="o" style="cursor:pointer">
                <div style="margin-top: 8px">
                  <router-link
                    :to="{path:'blog',query: {bid: o.id}}">{{ o.title  }}</router-link>
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
              <div v-for="o in youqings" :key="o" style="cursor:pointer">
                <div style="margin-top: 8px">
                  <a class="qing-item-link" :href="o.url">{{ o.name }}</a>
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
        bloghot: [],
        blognew: [],
        imgs: [],
        youqings: [],
        blogs: [],
        labels: [],
        labeltype: {
          0 : "blue",
          1 : "green",
          2 : "red",
          3 : "yellow"
        },
        condition : {
          pageSize : 6,
          pageNo: 1,
          title: null
        }

      }
    },
    created () {
      this.getblogs(),
      this.hotblog(),
      this.newblog(),
      this.youqing(),
      this.getimgs(),
      this.getlabels()
    },
    mounted () {
    },
    methods: {
      open () {
        this.$message('登录成功')
      },
      hotblog () {
        request.post('/blog/hotblog').then((res) => {
          if (res.data.code === 20) {
            this.bloghot = res.data.content
          }
        })
      },
      newblog () {
        request.post('/blog/newblog').then((res) => {
          if (res.data.code === 20) {
            this.blognew = res.data.content
          }
        })
      },
      getimgs () {
        request.post('/img/get').then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.imgs = res.data.content
          }
        })
      },
      youqing () {
        request.post('/youqing/index').then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.youqings = res.data.content
          }
        })
      },
      getblogs () {
        request.post('/blog/index',this.condition).then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.blogs = res.data.content
          }
        })
      },
      getlabels () {
        request.post('/label/all').then((res) => {
          if (res.data.code === 20) {
            this.labels = res.data.content
          }
        })
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
    margin-right: 3px;
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
