const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '新闻资讯管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'戏曲资料',
							url:'/index/newsList'
						},
					]
				},
				{
					name: '视频播放管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'视频播放',
							url:'/index/shipinbofangList'
						},
					]
				},
				{
					name: '音频播放管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'音频播放',
							url:'/index/yinpinbofangList'
						},
					]
				},
				{
					name: '艺术家管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'艺术家',
							url:'/index/yishujiaList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "中国戏曲文化传播系统"
        } 
    }
}
export default config
