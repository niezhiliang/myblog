import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import App from '@/App'
import Head from '@/pages/head'
import Blog from '@/pages/blogdetail'
import Sider from '@/pages/sider'
import Blogresume from '@/pages/blogresume'
import HotBlog from '@/pages/hotblog'
import Footer from '@/pages/footer'
import Father from '@/pages/parent'
import Main from '@/pages/indexmain'
import Qrcode from '@/pages/qrcode'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: App,
      children: [
        {
          path: '/',
          component: Main,
          name: 'home'
        },
        {
          path: '/index',
          component: Main,
          name: 'index'
        },
        {
          path: '/head',
          component: Head,
          name: 'head'
        },
        {
          path: '/footer',
          component: Footer,
          name: 'footer'
        },
        {
          path: '/blogresume',
          component: Blogresume,
          name: 'blogresume'
        },
        {
          path: '/hotblog',
          component: HotBlog,
          name: 'hotblog'
        },
        {
          path: '/blog',
          component: Blog,
          name: 'blog'
        },
        {
          path: '/sider',
          component: Sider,
          name: 'sider'
        },
        {
          path: '/main',
          component: Main,
          name: 'main'
        },
        {
          path: '/qrcode',
          component: Qrcode,
          name: 'qrcode'
        }
      ]
    }
  ]
})
