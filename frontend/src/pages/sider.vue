<template>
  <div>
    <Sider :style="{backgroundColor:'#fff',minHeight: '1000px',minWidth: '360px',padding: '20px',marginTop: '20px'}">
      <Card :style="{padding: '0px'}" :key="1">
        <h5 slot="title" style="text-align: left">标签</h5>
        <Tag checkable color="blue" v-for="(l,index) in labels" :key="index">{{l.labelname}}</Tag>
      </Card>

      <Card :style="{marginTop: '20px'}" :key="2">
        <h5 slot="title" style="text-align: left">苏雨</h5>
        <Avatar :style="{height:'96px',width: '96px',marginBottom: '20px',marginTop: '20px'}" src="https://avatar.csdn.net/E/4/A/1_qq_38082304.jpg?1520594137" shape="square" icon="person" size="large" />
        <div style="float: right;margin-top: 25px;margin-right: 20px" align="right" v-model="webdatas">
          <p><span style="margin-right: 5px;color: #4f4f4f">{{ webdatas.blogcount }}</span><span style="color: #788087;font-size: 14px">文章</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">{{ webdatas.commentcount }}</span><span style="color: #788087;font-size: 14px">评论</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">{{ webdatas.readcount }}</span><span style="color: #788087;font-size: 14px">访问</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">{{ webdatas.onlinecount }}</span><span style="color: #788087;font-size: 14px">在线</span></p>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}" :key="4">
        <h5 slot="title" style="text-align: left">最新发布</h5>
        <div :style="{fontSize: '13px'}" v-for="(blog,key) in blognew" :name="key">
          <router-link
            :to="{path:'blog',query: {bid: blog.id}}">{{ blog.title  }}</router-link>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}" :key="3">
        <h5 slot="title" style="text-align: left">评论排行</h5>
        <div :style="{fontSize: '13px'}" v-for="(blog,key) in comments" :name="key">
          <router-link @click="onClickMe(blog.id)"
            :to="{path:'blog',query: {bid: blog.id}}">{{ blog.title  }}</router-link>
          <p style="text-align: right;color: #67c23a">{{ blog.comment}}</p>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}" :key="5">
        <h5 slot="title" style="text-align: left">友情链接</h5>
        <div :style="{fontSize: '13px'}" v-for="(yq,key) in youqings" :name="key">
          <a :href="yq.url">
            {{ yq.name }}
          </a>
        </div>
      </Card>

    </Sider>
  </div>
</template>

<script>
  import request from '@/components/request'
  export default {
    data() {
      return {
        blognew: [],
        webdatas: {
          blogcount: 0,
          readcount: 0,
          commentcount: 0,
          onlinecount: 0
        },
        youqings: [],
        labels: [],
        comments: [],
        labeltype: {
          0 : "blue",
          1 : "green",
          2 : "red",
          3 : "yellow"
        },
        bid: 1
      }
    },
    created () {
      this.getlabels(),
      this.newblog(),
      this.youqing(),
      this.webdata(),
      this.ordercomment()
    },
    methods: {
      onClickMe: function(id){
        this.bid = id
        this.$emit('child-say',this.bid)
      },
      ordercomment () {
        request.post('/blog/orderbycomment').then((res) => {
          if (res.data.code === 20) {
          this.comments = res.data.content
        }
      })
      },
      webdata () {
        request.post('/blog/webdata').then((res) => {
          if (res.data.code === 20) {
          this.webdatas = res.data.content
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
      }
    }
  }
</script>
<style>
  a{
    color: #c88326;
  }
</style>
