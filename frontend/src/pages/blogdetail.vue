<template>
  <div>
    <vheader :activeIndex="1"></vheader>
    <Row type="flex" justify="center" align="top" class="code-row-bg" :style="{maxWidth:'1600px',margin: '0 auto'}">
      <i-col :xs="{ span: 22, offset: 1 }" :sm="{span: 22, offset: 1}" :md="{span: 15}"  :lg="{span: 13}" :style="{marginRight:'30px'}">
        <!-- 页面左侧模块-->
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
              <div v-html="bdetail.content"></div>
            </el-card>
      </i-col>
          <i-col :xs="{ span: 22 }" :sm="{span: 22}" :md="{span: 7}"  :lg="{span: 5}">
            <sider v-on:child-say="sonsay"></sider>
          </i-col>
    </Row>
    <div>
      <Footer class="layout-footer-center">2011-2016 &copy; TalkingData</Footer>
    </div>
  </div>
</template>

<script>
  import vheader from '@/pages/head'
  import request from '@/components/request'
  import sider from '@/pages/sider'
 // import footer from '@/pages/footer'
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
          bid: 2
        },
        bdetail:{

        }
      }
  },
    created () {
    },
    mounted () {
      this.condition.bid = this.$route.query.bid
      this.getdetail()
    },
    methods: {
      sonsay: function (bid) {
        this.condition.bid = bid
        this.getdetail()
      },
      getdetail () {
        request.post('/blog/detail',this.condition).then((res) => {
          if (res.data.code === 20) {
          this.bdetail = res.data.content
        }
      })
      }
     },
    components: { vheader ,sider  }
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

