<template>
  <div>
    <vheader></vheader>
   <Row>
     <i-col :xs="{ span: 20, offset: 2 }" :sm="{span: 20, offset: 2}" :md="{span: 13, offset: 2}"
            :lg="{span: 14}">
       <template>
         <el-carousel style="margin-top: 20px">
           <el-carousel-item v-for="(img,key) in imgs" :key="key">
             <img style="width: 100%;height: 100%;display: block;" :src="img.url" />
           </el-carousel-item>
         </el-carousel>
       </template>
       <resume></resume>
       <!-- 分页 -->
       <el-pagination
         background
         layout="prev, pager, next"
         prev-text="上一页"
         next-text="下一页"
         @current-change="pagemethod"
         :total="40"
         style="margin-top: 10px;background-color:#fff;padding: 10px;">
       </el-pagination>
     </i-col>
     <i-col :xs="{ span: 20}" :sm="{span: 20}" :md="{span: 7}"
            :lg="{span: 6}">
       <sider></sider>
     </i-col>
   </Row>
  </div>
</template>

<script>
  import vheader from '@/pages/head'
  import request from '@/components/request'
  import sider from '@/pages/sider'
  import resume from '@/pages/blogresume'
  import hotblog from '@/pages/hotblog'

  export default {
    data () {
      return {
        imgs: [],
        condition : {
          pageSize : 6,
          pageNo: 1,
          title: null
        }
      }
    },
    created () {
      this.getimgs()
    },
    methods: {
    getimgs () {
      request.post('/img/get').then((res) => {
        if (res.data.code === 20) {
          console.log(res.data.content)
          this.imgs = res.data.content
        }
      })
    },
      pagemethod: function(val) {
        this.condition.pageNo = val
        this.$refs.bresume.getparams(this.condition.pageNo)
      }
    },
    components: { vheader ,sider ,resume ,hotblog  }
  }
</script>

<style>
</style>
