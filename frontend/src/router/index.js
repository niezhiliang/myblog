import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import App from '@/App'
import Head from '@/pages/head'
import Login from '@/pages/login'
import Regist from '@/pages/regist'
import Blog from '@/pages/blogdetail'
import Sider from '@/pages/sider'
import Blogresume from '@/pages/blogresume'
import HotBlog from '@/pages/hotblog'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: App,
      children: [
        {
          path: '/',
          component: Index,
          name: 'home'
        },
        {
          path: '/index',
          component: Index,
          name: 'index'
        },
        {
          path: '/head',
          component: Head,
          name: 'head'
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
        }
      ]
    }
  ]
})
