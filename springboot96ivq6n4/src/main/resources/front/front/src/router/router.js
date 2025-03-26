import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import tiezileibieList from '../pages/tiezileibie/list'
import tiezileibieDetail from '../pages/tiezileibie/detail'
import tiezileibieAdd from '../pages/tiezileibie/add'
import jiaoliuzhongxinList from '../pages/jiaoliuzhongxin/list'
import jiaoliuzhongxinDetail from '../pages/jiaoliuzhongxin/detail'
import jiaoliuzhongxinAdd from '../pages/jiaoliuzhongxin/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discussjiaoliuzhongxinList from '../pages/discussjiaoliuzhongxin/list'
import discussjiaoliuzhongxinDetail from '../pages/discussjiaoliuzhongxin/detail'
import discussjiaoliuzhongxinAdd from '../pages/discussjiaoliuzhongxin/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'tiezileibie',
					component: tiezileibieList
				},
				{
					path: 'tiezileibieDetail',
					component: tiezileibieDetail
				},
				{
					path: 'tiezileibieAdd',
					component: tiezileibieAdd
				},
				{
					path: 'jiaoliuzhongxin',
					component: jiaoliuzhongxinList
				},
				{
					path: 'jiaoliuzhongxinDetail',
					component: jiaoliuzhongxinDetail
				},
				{
					path: 'jiaoliuzhongxinAdd',
					component: jiaoliuzhongxinAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discussjiaoliuzhongxin',
					component: discussjiaoliuzhongxinList
				},
				{
					path: 'discussjiaoliuzhongxinDetail',
					component: discussjiaoliuzhongxinDetail
				},
				{
					path: 'discussjiaoliuzhongxinAdd',
					component: discussjiaoliuzhongxinAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
