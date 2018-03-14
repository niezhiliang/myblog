<template>
  <div>
    <el-card  :key=b.id class="box-card card-border" style="margin-top: 10px;padding-top: 10px"
              v-for="b in blogs">
      <div style="margin-top: -10px">
        <span class="qing-category">{{ b.blogType }}</span>
        <i class="el-icon-caret-right icon-size" ></i>
        <router-link
          :to="{path:'blog',query: {bid: b.id}}" style="color: cornflowerblue;font-size: 16px">{{ b.title  }}</router-link>
      </div>
      <div class="qing-list-hint">
        <span><Icon type="person" style="font-size: 13px;color:#01AAED"></Icon> 苏雨 </span>
        <span><Icon type="clock" style="color: darkgoldenrod;"></Icon>&nbsp; {{ b.createtime | time }}&nbsp;</span>
        <span><Icon type="ios-eye" style="color:#01AAED;font-size: 15px"></Icon>&nbsp;阅读({{ b.readcount }})&nbsp;</span>
        <span><Icon type="ios-chatboxes" style="font-size: 13px;color:#67c23a;"></Icon>&nbsp;评论( {{ b.comment }})</span>
      </div>
      <p class="qing-list-content">{{ b.resume }}</p>
      <div class="qing-list-foot">
        <Icon type="ios-pricetags" style="margin-right: 5px"></Icon>
        <span class="am-radius" v-for="l in b.types">#{{ l.labelname }}</span>
        <router-link
          :to="{path:'blog',query: {bid: b.id}}" class="qing-read-more">阅读全文&gt;&gt;</router-link>
      </div>
    </el-card>
    <!-- 分页 -->
    <el-pagination v-model="condition"
      background
      layout="prev, pager, next"
      prev-text="上一页"
      next-text="下一页"
      @current-change="pagemethod"
      :total="condition.count"
      :page-size="condition.pageSize"
      style="margin-top: 10px;background-color:#fff;padding: 10px;">
    </el-pagination>
  </div>
</template>


<script>
  import request from '@/components/request'


  export default {

    data () {
      return {
        blogs: [],
        condition : {
          pageSize : 6,
          pageNo: 1,
          title: null,
          count: 0
      },
      }
    },
    props:[
      'psno'
    ],
    created () {
    },
    mounted () {
      this.getblogs()
    },
    methods: {
      getblogs () {
        request.post('/blog/index',this.condition).then((res) => {
          if (res.data.code === 20) {
          this.blogs = res.data.content.blogs
          console.log(this.blogs)
          this.condition.count = res.data.content.total
        }
      })
      },
      pagemethod: function(val) {
        this.condition.pageNo = val
        this.getblogs()
      }
    }
  }
</script>

<style scoped>
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
  .qing-category{
    color: #fff;
    background-color: #1abc9c;
    padding: 3px 6px;
    font-size: 10px;
    position: relative;
    top: -2px;
    margin-right: 5px;
  }
  .icon-size{
    color:rgb(26, 188, 156);
    margin-left: -18px;
    font-size: 20px
  }
  .qing-read-more{
    margin: 0.15rem 0.15rem;
    font-size: 10px;
    float: right;
    color: #009688;
  }

</style>


