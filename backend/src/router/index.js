import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index'
import Public from '@/pages/public'
import App from '@/App'

Vue.use(Router)

export default new Router({
    routes: [{
        path: '/',
        component: App,
        children: [
          {
            path: '/public',
            name: 'public',
            component: Public
          }
        ]
    }]
})
