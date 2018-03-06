import Vue from 'vue'
import Router from 'vue-router'
import Public from '@/pages/public'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Public,
      children: [
        {
          path: '/index',
          component: Public,
          name: 'index'
        }
      ]
    }
  ]
})
