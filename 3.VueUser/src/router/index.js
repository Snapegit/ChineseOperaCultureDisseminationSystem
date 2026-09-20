import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import newsList from '@/views/pages/news/list'
import xiqufenleiList from '@/views/pages/xiqufenlei/list'
import xiqufenleiDetail from '@/views/pages/xiqufenlei/formModel'
import xiqufenleiAdd from '@/views/pages/xiqufenlei/formAdd'
import shipinbofangList from '@/views/pages/shipinbofang/list'
import shipinbofangDetail from '@/views/pages/shipinbofang/formModel'
import shipinbofangAdd from '@/views/pages/shipinbofang/formAdd'
import storeupList from '@/views/pages/storeup/list'
import yishujiaList from '@/views/pages/yishujia/list'
import yishujiaDetail from '@/views/pages/yishujia/formModel'
import yishujiaAdd from '@/views/pages/yishujia/formAdd'
import yinpinbofangList from '@/views/pages/yinpinbofang/list'
import yinpinbofangDetail from '@/views/pages/yinpinbofang/formModel'
import yinpinbofangAdd from '@/views/pages/yinpinbofang/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'xiqufenleiList',
			component: xiqufenleiList
		}, {
			path: 'xiqufenleiDetail',
			component: xiqufenleiDetail
		}, {
			path: 'xiqufenleiAdd',
			component: xiqufenleiAdd
		}
		, {
			path: 'shipinbofangList',
			component: shipinbofangList
		}, {
			path: 'shipinbofangDetail',
			component: shipinbofangDetail
		}, {
			path: 'shipinbofangAdd',
			component: shipinbofangAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'yishujiaList',
			component: yishujiaList
		}, {
			path: 'yishujiaDetail',
			component: yishujiaDetail
		}, {
			path: 'yishujiaAdd',
			component: yishujiaAdd
		}
		, {
			path: 'yinpinbofangList',
			component: yinpinbofangList
		}, {
			path: 'yinpinbofangDetail',
			component: yinpinbofangDetail
		}, {
			path: 'yinpinbofangAdd',
			component: yinpinbofangAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
