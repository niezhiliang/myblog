<template>
  <div>
    <vheader :activeIndex="1"></vheader>
    <Row>
      <i-col :xs="18" :sm="4" :md="6" :lg="14" offset="3">
      <!-- 页面左侧模块-->
        <el-aside width="860px" style="height: 100%">
          <template>
            <el-carousel>
              <el-carousel-item v-for="(img,key) in imgs" :key="key">
                <img style="width: 100%;height: 100%;display: block;" :src="img.url" />
              </el-carousel-item>
            </el-carousel>
          </template>
          <!-- 热门排行 -->
          <hotblog></hotblog>
          <!-- 文章简介卡片 -->
          <resume ref="bresume" :psno="condition.pageNo"></resume>
          <!-- 分页 -->
            <el-pagination
              background
              layout="prev, pager, next"
              prev-text="上一页"
              next-text="下一页"

              @current-change="pagemethod"
              :total="60" style="margin-top: 10px;background-color:#fff;padding: 10px">
            </el-pagination>

        </el-aside>
      </i-col>
        <i-col span="4">
          <sider></sider>
        </i-col>
    </Row>
    <div>
      <Footer class="layout-footer-center">2011-2016 &copy; TalkingData</Footer>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import vheader from '@/pages/head'
  import request from '@/components/request'
  import sider from '@/pages/sider'
  import resume from '@/pages/blogresume'
  import hotblog from '@/pages/hotblog'
 // import footer from '@/pages/footer.vue'

  export default {
    name: 'Test',
    data () {
      return {
        imgs: [],
        condition : {
          pageSize : 6,
          pageNo: 1,
          title: null
        },
      }
    },
    created () {
      this.getimgs()
    },
    mounted () {
    },
    methods: {
      pagemethod: function(val) {
       this.condition.pageNo = val
        this.$refs.bresume.getparams(this.condition.pageNo)
      },
      getimgs () {
        request.post('/img/get').then((res) => {
          if (res.data.code === 20) {
            console.log(res.data.content)
            this.imgs = res.data.content
          }
        })
      },
    },
    components: { vheader ,sider ,resume ,hotblog  }
  }
</script>

<style>
  .layout-footer-center{
    text-align: center;
    background-color: #2F4056;
    font-size: 14px;
    color: white;
  }
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
