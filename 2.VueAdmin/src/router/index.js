	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import discussshipinbofang from '@/views/discussshipinbofang/list'
	import yonghu from '@/views/yonghu/list'
	import shipinbofang from '@/views/shipinbofang/list'
	import yishujia from '@/views/yishujia/list'
	import xiqufenlei from '@/views/xiqufenlei/list'
	import discussyinpinbofang from '@/views/discussyinpinbofang/list'
	import yinpinbofang from '@/views/yinpinbofang/list'
	import storeup from '@/views/storeup/list'
	import config from '@/views/config/list'
	import users from '@/views/users/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页Home',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/news',
			name: '戏曲资料',
			component: news
		}
		,{
			path: '/discussshipinbofang',
			name: '视频播放评论',
			component: discussshipinbofang
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/shipinbofang',
			name: '视频播放',
			component: shipinbofang
		}
		,{
			path: '/yishujia',
			name: '艺术家',
			component: yishujia
		}
		,{
			path: '/xiqufenlei',
			name: '戏曲分类',
			component: xiqufenlei
		}
		,{
			path: '/discussyinpinbofang',
			name: '音频播放评论',
			component: discussyinpinbofang
		}
		,{
			path: '/yinpinbofang',
			name: '音频播放',
			component: yinpinbofang
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
