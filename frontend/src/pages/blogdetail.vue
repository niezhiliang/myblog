<template>
  <div>
    <vheader :activeIndex="1"></vheader>
    <div class="center">
      <!-- 页面左侧模块-->
      <el-container>
        <el-aside width="860px" style="height: 100%">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <Breadcrumb>
                <Breadcrumb-item href="/index">
                  <Icon type="ios-home-outline"></Icon> 首页
                </Breadcrumb-item>
                <Breadcrumb-item style="color:#2d8cf0">
                  {{ bdetail.title }}
                </Breadcrumb-item>
              </Breadcrumb>
            </div>
              <h1 style="text-align: center">{{ bdetail.title}}</h1>
            <div class="blog-data">
              <span><Icon type="person" style="font-size: 13px;color:#01AAED"></Icon> 苏雨丶 </span>
              <span><Icon type="clock" style="color: darkgoldenrod;"></Icon>&nbsp; {{ bdetail.createtime | time}}&nbsp;</span>
              <span><Icon type="ios-eye" style="color:#01AAED;font-size: 15px"></Icon>&nbsp;阅读({{ bdetail.readcount }})&nbsp;</span>
              <span><Icon type="ios-chatboxes" style="font-size: 13px;color:#67c23a;"></Icon>&nbsp;评论({{ bdetail.comment }})</span>
            </div>
            <!--摘要：-->
            <!--<span>{{ bdetail.resume }}</span>-->
            <div v-html="bdetail.content"></div>
          </el-card>
          <div>

          </div>
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
                <div style="margin-top: 8px"  @click="aa()">
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

<script>
  import vheader from '@/pages/head'
  import request from '@/components/request'
  import sider from '@/pages/sider'
  export default {
    name: 'HelloWorld',
    data () {
      return {
        blognew: [],
        youqings: [],
        labels: [],
        labeltype: {
          0 : "blue",
          1 : "green",
          2 : "red",
          3 : "yellow"
        },
        condition:{
          bid: 1
        },
        bdetail:{

        }
      }
  },
    created () {
        this.newblog(),
        this.youqing(),
        this.getlabels(),
        this.getdetail()
    },
    mounted () {
      this.condition.bid = this.$route.query.bid
    },
  methods: {
      aa () {
        location.reload()
      },
    newblog () {
      request.post('/blog/newblog').then((res) => {
        if (res.data.code === 20) {
        this.blognew = res.data.content
      }
    })
    },
    youqing () {
      request.post('/youqing/index').then((res) => {
        if (res.data.code === 20) {
        this.youqings = res.data.content
      }
    })
    },
    getlabels () {
      request.post('/label/all').then((res) => {
        if (res.data.code === 20) {
        this.labels = res.data.content
      }
    })
    },
    getdetail () {
      request.post('/blog/detail',this.condition).then((res) => {
        if (res.data.code === 20) {
          console.log(res.data)
        this.bdetail = res.data.content
      }
    })
    }
    },
    components: { vheader ,sider }
  }
</script>

<style>
  .center {
    margin-left: 15%;
    margin-right:15%;
    margin-top: 20px;
    background-color: #fff;
  }
  .blog-data {
    text-align: center;
    margin-top: 5px;
    margin-bottom: 15px;
  }
  pre {
    background: #f6f6f6;
    color: #657b83;
    -webkit-text-size-adjust: none;
  }
</style>

