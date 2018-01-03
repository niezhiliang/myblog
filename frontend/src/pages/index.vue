<template>
    <div>
    <vheader :activeIndex="1"></vheader>
    <div class="center">
      <!-- 页面左侧模块-->
      <el-container>
        <el-aside width="260px">
          <div style="padding-bottom: 20px;">
            <el-tag type="success">
              <span style="font-weight:bold;">个人资料</span>
            </el-tag>
          </div>
          <div class="my-info">
            <el-tag id="headimg">
              <img id="myimg" :src="lefttop.user.headimage"/>
            </el-tag>
            <div style="margin-top: 10px;">
                <span style="text-align: center;">{{ lefttop.user.username }}</span>
            </div>
          </div>
          <div class="my-info" style="text-align: left">
            <div class="art-data">
              <label>文章：</label><span>{{ lefttop.blogcount }}</span>
            </div>
            <div class="art-data">
               <label>访问：</label><span>{{ lefttop.visitcount }}</span>
            </div>
            <div class="art-data">
               <label>评论：</label><span>{{ lefttop.comments }}</span>
            </div>
          </div>
          <div class="center-spance"></div>
          <div style="padding-bottom: 20px;">
            <el-tag type="success">
              <span style="font-weight:bold;">文章搜索</span>
            </el-tag>
          </div>
          <div id="select-art">
              <el-input placeholder="请输入内容" v-model="select.search" class="input-with-select">
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
          </div>
          <div class="center-spance"></div>
          <div>
            <el-tag type="success">
              <span style="font-weight:bold;">文章分类</span>
            </el-tag>
          </div>
          <div class="my-info" style="text-align: left;border: none">
            <div  v-for="(tag, index) in tags" @click="selectkind(tag.lid)" :tid="tag.lid" @mouseover="changestyle()">
              <el-tag class="tip-kind"
                      :key="tag.count"
                      :type="tarcolor[index]"
                      :disable-transitions="true"
              >
                {{tag.labelname}}
                <div style="float: right;margin-bottom: -10px">{{ tag.count }}</div>
              </el-tag>
            </div>
          </div>
          <div class="center-spance"></div>
          <div>
            <el-tag type="success">
              <span style="font-weight:bold;">阅读排行</span>
            </el-tag>
          </div>
          <div class="my-info" style="text-align: left;border: none;padding-right: 0px;">
            <div class="art-data" v-for="blog in blogord">
              <a href="#">{{blog.title}}</a><span class="top-read">(<span>{{blog.readcount}}</span>)</span>
            </div>
          </div>
          <div class="center-spance" style="background-color: #f4f4f4;height: 200px;"></div>
        </el-aside>
        <!-- 模块之间的间隔-->
        <div style="background-color: #f4f4f4;">
             <el-aside width="20px"></el-aside>
        </div>
        <!-- 页面中间模块-->
        <el-main>
           <div class="top-main">

           </div>
          <div class="blog-art-box" v-for="b in blogs">
            <div class="blog-title">
              <div class="tip-blog">{{type[b.type]}}</div>
              <router-link :to="{ name: 'blog' }">{{b.title}}</router-link>
            </div>
            <div class="blog-introduction"><span class="intro-font">{{b.resume}}</span></div>
            <div class="blog-detail">
               <span class="blog-data-art">
                 <i class="el-icon-edit-outline" style="font-size: 15px"></i>
                 <label>评论</label><span>(</span><span>{{b.comment}}</span><span>)</span>
              </span>
              <span class="blog-data-art">
                <i class="el-icon-view" style="font-size: 15px;"></i>
                 <label>阅读</label><span>(</span><span>{{b.readcount}}</span><span>)</span>
              </span>

              <span class="blog-data-art">
                  <i class="el-icon-time" style="font-size: 15px;"></i>
                <span>{{ b.creattime | time}}</span>
              </span>
            </div>
          </div>
         <!--分页-->
          <div class="block">
            <el-pagination
              layout="total, prev, pager, next"
              :total="count"
              :page-sizes="[2,5,6]"
              :page-size="select.pagesize"
              :current-page.sync="select.pageno"
              @current-change="changePage()"
              @size-change="changePage()"
            >
            </el-pagination>
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
          tags: [],
          type: {
            0: '新',
            1: '热'
          },
          select: {
            search: null,
            pageno: 1,
            pagesize: 5,
            lid: null
          },
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
          islogin: false,
          tarcolor: {
            0: 'success',
            1: 'info',
            2: 'warning',
            3: 'danger',
            4: '',
            5: 'success',
            6: 'info',
            7: 'warning',
            8: 'danger',
            9: '',
            10: 'success',
            11: 'info',
            12: 'warning',
            13: 'danger',
            14: ''
          }
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
  .center {
    margin-left: 15%;
    margin-right:15%;
    margin-top: 20px;
    background-color: #fff;
  }
  .el-tag--success{
    width: 100%;
    border-radius: 0px;
  }
  #headimg {
    width: 100%;
    height: 150px;
    background-color: #fff;
    border: none;
  }
  #myimg {
    width: 150px;
    height: 150px;
    border: none;
  }
  .my-info {
    text-align: center;
    padding-bottom: 10px;
    padding-top: 10px;
    border-bottom: dashed 1px #ccc;
    margin-bottom: 20px;
    margin-left: 20px;
    margin-right: 20px;
  }
  .art-data{
    font-size: 12px;
    padding-bottom: 5px;
    padding-top: 5px;
  }
.top-read{
  float: right;
}
  .center-spance {
    width: 100%;
    height: 15px;
    background-color:#f4f4f4;
  }
  #select-art {
    width: 96%;
    text-align: center;
    padding-left: 2%;
    padding-right: 2%;
    padding-bottom: 20px;
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
  a{
    text-decoration: none;
    color: red;
  }
  .tip-blog{
    width: 20px;
    height: 20px;
    border-radius: 7px;
    background-color: #67c23a;
    font-size: 12px;
    text-align: center;
    float: left;
    color:white;
    padding-top: 2px;
    margin-right: 10px;
  }
  .blog-detail{
    width: 100%;
    height: 30px;
    margin-top: 40px;
  }
  .blog-data-art{
    float: right;
    margin-right: 30px;
    font-size: 12px;
  }
  .block{
    margin-top: 30px;
    float: right;
  }
  .tip-kind {
    width: 100%;
    text-align: left;
    margin-top: 2px;
    cursor: pointer;
  }
  .el-pager li.active {
    color: #67c23a;
  }
</style>
