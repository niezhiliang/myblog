<template>
  <div style="padding-left: 10%;padding-right: 10%;">
    <h1 style="color: red;text-align: center;margin-top: 20px;">写文章</h1>
     <div style="margin-top: 20px">
       <Select style="width: 80px;display: flex" v-model="blog.typeId">
         <Option :value=" obj.id" v-for="obj in types">{{ obj.blogtype }}</Option>
       </Select>
       <Input v-model="blog.title" placeholder="输入文章标题"></Input>
       <Input v-model="blog.resume" style="margin-top: 20px" type="textarea" :autosize="{minRows: 5,maxRows: 5}" placeholder="文章简介"></Input>
     </div>
    <div class="markdown">
      <markdown ref="mymark"></markdown>
    </div>
    <div style="margin-top: 10px">
      <p style="color: red;font-size: 14px">文章标签：</p>
      <CheckboxGroup v-model="blog.selected">
      <Checkbox :label="obj.id" v-for="obj in labels">{{ obj.labelname }}</Checkbox>
    </CheckboxGroup>
    </div>
    <div class="btnlist">
      <Button class="btn" type="primary" @click="public">立即发布</Button>
      <Button type="ghost" style="margin-left: 8px">保存草稿</Button>
    </div>
  </div>
</template>

<script>
  import markdown from '../components/index'
  import request from '@/components/request'
  export default {
    name: 'public',
    data() {
      return {
        labels:[],
        types:[],
        blog: {
          title: null,
          html: null,
          markdown: null,
          typeId: null,
          resume: null,
          selected: []
        }
      }
    },
    created () {
      this.getLabels(),
      this.getTypes()
    },
    components: {
      markdown
    },
    methods: {
      getLabels () {
        request.post('/label/all').then((res) => {
          if (res.data.code === 20) {
          this.labels = res.data.content
        }
      })
      },
      getTypes () {
        request.post('/type/all').then((res) => {
          if (res.data.code === 20) {
          this.types = res.data.content
        }
      })
      },
      public() {
        //调用子模块方法 获取html的代码
        this.$refs.mymark.getHtmlValueFn();
        this.blog.html = this.$refs.mymark.msgShow
        console.log(this.blog.content)
        //调用子模块的方法  获取markdown的方法
        this.$refs.mymark.getMdValueFn();
        this.blog.markdown = this.$refs.mymark.msgShow
        request.post('/blog/public',this.blog).then((res) => {
          if (res.data.code === 20) {
          this.types = res.data.content
        }
      })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .markdown {
    width: 100%;
    height: 700px;
    margin-top: 20px;
  }
  .btnlist{
    margin-top: 20px;
    text-align: center;
    .btn{
    }
  }
</style>
