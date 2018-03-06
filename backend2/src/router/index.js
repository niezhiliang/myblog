import Vue from 'vue'
import Router from 'vue-router'
import Left from '@/pages/left'
import Index from '@/pages/index'
import Markdown from '@/pages/markdown-editor'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Index,
      children: [
        {
          path: '/left',
          component: Left,
          name: 'left'
        },
        {
          path: '/markdown',
          component: Markdown,
          name: 'markdown'
        }
      ]
    }
  ]
})
