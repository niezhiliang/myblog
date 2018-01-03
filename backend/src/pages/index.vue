<template>
  <div id="" >
    <el-container>
      <el-aside width="200px">
        <div style="text-align: center;margin-top: 20px;margin-bottom:10px;font-weight: bold;font-size: 22px;color: white">
          苏雨后台管理
        </div>
        <div style="background-color:#545c64 ">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
              <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-setting"></i>
              <span slot="title">导航三</span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main>
        <div >
          <div class="public-box" style="padding-right: 5%;padding-left: 5%; padding-top: 30px; padding-bottom: 30px;">
            <div style="text-align: center;margin-bottom: 10px;font-size: 20px;font-weight: bold;color: #409eff">
            <span>文章发布</span>
            </div>
            <div style="height: 16px;float: left;width: 6px;background-color: orange;margin-top: 4px; margin-right: 6px;"></div>
            <label style="color: #5a5e66;">标题</label>
            <hr/>
            <el-input v-model="blog.title" placeholder="请输入文章标题" max="80%"></el-input>
            <div style="margin-top: 10px;">
              <div style="height: 16px;float: left;width: 6px;background-color: orange;margin-top: 4px; margin-right: 6px;"></div>
              <label style="color: #5a5e66;">摘要</label>
            </div>
            <hr/>
            <el-input
              type="textarea"
              :autosize="{ minRows: 3, maxRows: 3}"
              placeholder="请输入内容"
              v-model="blog.resume">
            </el-input>
            <div style="margin-top: 10px;">
              <div style="height: 16px;float: left;width: 6px;background-color: orange;margin-top: 4px; margin-right: 6px;"></div>
              <label style="color: #5a5e66;">正文</label>
            </div>
            <hr/>
            <div class="write-mark">
              <el-input id="textarea"
                type="textarea"
                :autosize="{ minRows: 12, maxRows: 12}"
                placeholder="请输入正文"
                 @input="valuechange">
              </el-input>
            </div>
            <div style="background-color: #878d99;width: 100%;">
              实时更新
            </div>
            <div id="preview" class="write-mark" style="overflow:scroll;padding-left: 35px;
    padding-right: 35px; width: 94%;height: 300px">
              <p style="color:#d8dce5;text-align: center;font-size: 24px; ">Markdown 实时预览</p>
            </div>
            <div style="margin-top: 10px;">
              <div style="height: 16px;float: left;width: 6px;background-color: orange;margin-top: 4px; margin-right: 6px;"></div>
              <label  style="color: #5a5e66;">文章分类</label>
            </div>
            <hr/>
            <!--<el-input v-model="checkList" placeholder="请选择分类"  max="80%"></el-input>-->
            <el-checkbox-group v-model="types">
              <el-checkbox v-for="l in checkList" label="{{ l.id }}">{{ l.labelname }}</el-checkbox>
            </el-checkbox-group>
            <div style="margin: 20px 0;text-align: center">
              <el-button type="primary" @click="pubBlog()">立即发布</el-button>
              <el-button type="warning">保存草稿</el-button>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
  import vleft from '@/pages/left'
  import $ from 'jquery'
  import request from "../components/request";
  export default {
    name: 'HelloWorld',
    data () {
      return {
        checkList: [],
        blog: {
          title: '',
          resume: '',
          content: '',
          types: []
        }
      }
    },
    created () {
      this.initTags()
    },
    methods: {
      valuechange (){
        var text = document.getElementById('textarea').value
        var converter = new showdown.Converter()
        this.blog.content = converter.makeHtml(text)
        document.getElementById('preview').innerHTML = this.blog.content
      },
      pubBlog () {
        console.log(123)
        request.post('/blog/pub', this.blog).then((res) => {
          console.log(res.data)
        })
      },
      initTags () {
        request.post('/label/getlabels').then((res) => {
          this.checkList = res.data.content
          console.log(this.checkList)
        })
      }
    },
    components: { vleft }
  }
</script>
<style>
  .public-box{
    background-color: cornsilk;
  }
  .el-main{
    margin: 5px;
    padding: 2px;
  }
  .el-aside {
    background-color: rgb(84, 92, 100);
    padding-right: 3px;
  }
  .el-menu {
    border-righ:rgb(84, 92, 100);
  }
  .write-mark {
    width: 100%;
    border: 2px solid white;
  }
  #textarea{
    font-size: 17px;
    color: #b4bccc;
  }
</style>
