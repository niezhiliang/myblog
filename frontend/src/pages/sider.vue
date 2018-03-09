<template>
  <div>
    <Sider :style="{backgroundColor:'#fff',minHeight: '1000px',minWidth: '360px',padding: '20px',marginTop: '20px'}">
      <Card :style="{padding: '0px'}">
        <h5 slot="title" style="text-align: left">标签</h5>
        <Tag checkable color="blue">标签一</Tag>
        <Tag checkable color="green">标签二</Tag>
        <Tag checkable color="red">标签三</Tag>
        <Tag checkable color="yellow">标签四</Tag>
        <Tag checkable color="blue">标签一</Tag>
        <Tag checkable color="green">标签二</Tag>
        <Tag checkable color="red">标签三</Tag>
        <Tag checkable color="yellow">标签四</Tag>
        <Tag checkable color="yellow">标签四</Tag>
      </Card>

      <Card :style="{marginTop: '20px'}">
        <h5 slot="title" style="text-align: left">苏雨</h5>
        <Avatar :style="{height:'96px',width: '96px',marginBottom: '20px',marginTop: '20px'}" src="https://avatar.csdn.net/E/4/A/1_qq_38082304.jpg?1520594137" shape="square" icon="person" size="large" />
        <div style="float: right;margin-top: 25px;margin-right: 20px" align="right">
          <p><span style="margin-right: 5px;color: #4f4f4f">100</span><span style="color: #788087;font-size: 14px">文章</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">100</span><span style="color: #788087;font-size: 14px">评论</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">100</span><span style="color: #788087;font-size: 14px">访问</span></p>
          <p><span style="margin-right: 5px;color: #4f4f4f">100</span><span style="color: #788087;font-size: 14px">在线</span></p>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}">
        <h5 slot="title" style="text-align: left">热门排行</h5>
        <div :style="{fontSize: '13px'}" v-for="(blog,key) in blogs" :name="key">
          <a href="#">
            {{ blog }}
          </a>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}">
        <h5 slot="title" style="text-align: left">最新发布</h5>
        <div :style="{fontSize: '13px'}" v-for="(blog,key) in blogs" :name="key">
          <a href="#">
            {{ blog }}
          </a>
        </div>
      </Card>

      <Card :style="{marginTop: '20px'}">
        <h5 slot="title" style="text-align: left">友情链接</h5>
        <div :style="{fontSize: '13px'}" v-for="(blog,key) in blogs" :name="key">
          <a href="#">
            {{ blog }}
          </a>
        </div>
      </Card>

    </Sider>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        blogs:[
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递",
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递",
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递",
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递",
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递",
          "JWT如何在Spring Cloud微服务系统中在服务相互调时传递"
        ]
      }
    }
  }
</script>
<style>
  a{
    color: #c88326;
  }
</style>
