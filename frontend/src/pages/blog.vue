<template>
  <div>
  <vheader :activeIndex="2"></vheader>
  <div class="blog-main">
    <div class="blog-title">
         <h2 class="csdn_top">面向对象的思想</h2>
      <div class="artical_tag">
        <el-tag class="tag-kind">Java</el-tag>
        <el-tag class="tag-kind">Springboot</el-tag>
        <div>
          <span class="time" style="margin-right: 5%">
             <i class="el-icon-time" style="font-size: 15px;"></i>
              <span>2017-11-12 21:12</span>
          </span>
          <span class="read" style="margin-right: 20px">
              <i class="el-icon-view" style="font-size: 15px;"></i>
              <label>阅读</label><span style="margin-left: 10px">6666</span>
         </span>
        </div>
      </div>

    </div>
    <div class="blog-title" style="margin-top: 10px;height: 100px;">

    </div>
    <div  class="blog-true">
    <article class="article-content">
      <p>之前也发表过这样的一篇文章，可发现自己没有写好，所以今天又重新写了一下，这回就可以了。</p>
      <p>前面可能有些东西没有理清，跟大家说声抱歉。</p>
      <h3>首先我们先列出java的基本结构<br>
        //——————-类—————————-<br>
        public class Twinkle(类名){<br>
        //——————属性—————————<br>
        (public、private、protected) name；<br>
        属性里面的三种定义类型：<br>
        public :简单说就是对外开放的，所有类和方法都可以引用它。<br>
        private:私有的属性，只能在本类中使用，不对外开放。<br>
        protected:这个要考虑到父类继承子类，可以应用在子类里边。<br>
        //——————构造器————————<br>
        以前说过，构造器必须和它的类名是一样的，看结构。<br>
        public （类名）(加参数){<br>
        一般如果我们没有添加这个构造器也是可以的，因为你如果不添加构造器，执行时会默认的为你生成一个构造器<br>
        构造器具体要运用的话，我们还要了解一样方法的重载和重写（等后面说哈）。<br>
        }<br>
        //——————普通方法———————–<br>
        public (返回类型) （方法名）(参数){<br>
        返回类型一般是两种{void:（不返回值）<br>
        基本数据类型（像 int，double。。。）<br>
        {基本数据类型还要知道一件事情哈~，它必须有返回值，就是return 返回值，这样才可以}；<br>
        参数也要具体说一下吧，参数分为实参和形参。<br>
        形参：就上面那位，定义时候的参数 一般是这样的（数据类型 变量名）<br>
        实参：引用时候的参数，就叫实参，看下面。<br>
        参数的引用还有点小问题到后面说~；<br>
        }<br>
        //——————-主方法—————————<br>
        public static void main(String [] args(这个参数其实也是形参的，具体讲解等下次哈)){<br>
        如果引用方法的话，必须先初始化类；<br>
        （数据类型）Twinkle a（自定义变量名）=new Twinkle();<br>
        引用方法：a.（方法名）<br>
        如果没有内容需要用System.out.print();做输出；</h3>
      <h3>}<br>
        }<br>
        我们通过结构来看一下面向对象的三种特性（这个结构只能看出封装性。。。尴尬）：<br>
        封装性：所有的属性和方法都是封装在类中的，所以具有封装性。<br>
        继承性：这里面我没有表达~就是父类继承子类，字面理解一下哈，后面我会讲到。<br>
        多态性：也先字面理解一下。。后面还会给大家讲</h3>
      <p>好啦~今天就先说到这里哈，感谢大家的支持</p>
      <p>转载请注明：<a href="http://cuiqingcai.com" data-original-title="" title="">静觅</a> » <a href="http://cuiqingcai.com/4849.html" data-original-title="" title="">面向对象结构1</a></p>


      <div class="article-social">
        <a href="javascript:;" data-action="ding" data-id="4849" id="Addlike" class="action" data-original-title="" title=""><i class="fa fa-heart-o"></i>喜欢 (<span class="count">19</span>)</a><span class="or">or</span><span class="action action-share bdsharebuttonbox bdshare-button-style0-24" data-bd-bind="1510583913006"><i class="fa fa-share-alt"></i>分享 (<span class="bds_count" data-cmd="count" title="累计分享0次">0</span>)<div class="action-popover"><div class="popover top in"><div class="arrow"></div><div class="popover-content"><a href="#" class="sinaweibo fa fa-weibo" data-cmd="tsina" title="" data-original-title="分享到新浪微博"></a><a href="#" class="bds_qzone fa fa-star" data-cmd="qzone" title="" data-original-title="分享到QQ空间"></a><a href="#" class="tencentweibo fa fa-tencent-weibo" data-cmd="tqq" title="" data-original-title="分享到腾讯微博"></a><a href="#" class="qq fa fa-qq" data-cmd="sqq" title="" data-original-title="分享到QQ好友"></a><a href="#" class="bds_renren fa fa-renren" data-cmd="renren" title="" data-original-title="分享到人人网"></a><a href="#" class="bds_weixin fa fa-weixin" data-cmd="weixin" title="" data-original-title="分享到微信"></a><a href="#" class="bds_more fa fa-ellipsis-h" data-cmd="more" data-original-title="" title=""></a></div></div></div></span>
      </div>
    </article>
    </div>
    <div class="modual-space"></div>
    <div class="user-comment">
      <img class="head-img-co" src="http://avatar.csdn.net/E/4/A/1_qq_38082304.jpg"/>
      <div class="user-comment-box">
        <el-input
          type="textarea"
          :rows="3"
          placeholder="请畅所欲言........."
          v-model="textarea">
        </el-input>
        <div style="float: right">
          <el-button type="primary" round>提交</el-button>
        </div>
      </div>
    </div>
    <div class="allcomnucate" v-for="c in comunates">
      <img class="head-img-co" :src=" c.headimg "/>
      <ul class="allcomnucate-detail">
        <div>
          <li>
            <router-link :to="{ name: 'login' }"><span style="">{{c.uname}}</span></router-link>
            <span class="content-time">{{c.ctime}}</span>
            <span class="time" style="margin-right: 40px;font-size: 16px;">#{{c.floor}}楼</span>
          </li>
        </div>
        <li class="content">
          xxxx
        </li>
        <li style="margin-top: 5px; font-size: 14px;">
          <a href="#" >回复</a>
        </li>
      </ul>
      <div class="user-comment-box">

      </div>
    </div>
  </div>
  </div>
</template>

<script>
  import vheader from '@/pages/head'
  export default {
    name: 'HelloWorld',
    data () {
      return {
        comunates: [
          { uid: 1, ctime: '2017-11-15 10:28:35', uname: '苏雨丶', headimg: 'http://avatar.csdn.net/E/4/A/1_qq_38082304.jpg"', floor: 1 },
          { uid: 2, ctime: '2017-11-15 10:28:35', uname: '苏雨°', headimg: 'http://avatar.csdn.net/E/4/A/1_qq_38082304.jpg"', floor: 2 },
          { uid: 3, ctime: '2017-11-15 10:28:35', uname: '苏雨丶', headimg: 'http://avatar.csdn.net/E/4/A/1_qq_38082304.jpg"', floor: 3 },
          { uid: 4, ctime: '2017-11-15 10:28:35', uname: '苏雨°', headimg: 'http://avatar.csdn.net/E/4/A/1_qq_38082304.jpg"', floor: 4 }
        ],
        textarea: ''
      }
    },
    components: { vheader }
  }
</script>

<style scoped>
  .blog-main{
    background-color:#eee;
    margin-top: 30px;
    padding: 20px;
  }
  .blog-title {
    border-bottom:1px solid #fff;
    padding-bottom: 20px;

  }
  .blog-true{
    margin-top: 10px;
    border: 1px dashed #fff;
  }
  .article-content{
    margin-left: 10%;
    margin-right: 10%;
  }
  .csdn_top {
    padding: 0 29px;
    color: #2c3033;
    font-size: 24px;
    font-weight: bold;
    line-height: 38px;
  }
  .artical_tag {
    margin-left: 30px;
    margin-bottom: 10px;
    margin-top: -10px;
  }
  .time {
    color: #bbb;
    font-size: 14px;
    float: right;
  }
  .read{
    color: #bbb;
    font-size: 14px;
    float: right;
  }
  .modual-space {
    background-color: #f4f4f4;
    height: 40px;
  }
  .head-img-co{
    height: 40px;
    width: 40px;
    border-radius: 20px;
    float: left;
  }
  .user-comment{
    padding: 30px;
    border-bottom: 1px solid #663300;
    padding-bottom: 50px;
  }
  .user-comment-box{
    margin-left: 60px;
    margin-top: 10px;
    width: 60%;
  }
  .el-textarea {
    width: 100%;
    height: 80px;
    resize:none;
  }
  .el-button--primary{
    border-radius: 10px;
    height: 35px;
    text-align: center;
    background-color: #67c23a;
  }
  .allcomnucate{
    margin-top: 10px;
    padding-left: 70px;
    border-bottom: 1px dashed #663300;
  }
  .allcomnucate-detail{
    margin-left: 10px;
  }
  li {list-style-type:none;}
  .content {
    margin-top: 20px;
  }
  .content-time{
    color: #bbb;
    margin-left: 20px;
  }
  .tag-kind {

  }
</style>
