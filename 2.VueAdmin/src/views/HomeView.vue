<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
		<div class="count_list">
			<el-collapse-transition v-if="btnAuth('shipinbofang','首页总数')">
				<el-card v-show="countTypeList.closeshipinbofangCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								视频播放
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenshipinbofangCountType')" class="showIcons"
									:class="countTypeList.hiddenshipinbofangCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closeshipinbofangCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenshipinbofangCountType">
							<div class="count_title">视频播放总数</div>
							<div class="count_num">{{shipinbofangCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('yinpinbofang','首页总数')">
				<el-card v-show="countTypeList.closeyinpinbofangCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								音频播放
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenyinpinbofangCountType')" class="showIcons"
									:class="countTypeList.hiddenyinpinbofangCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closeyinpinbofangCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenyinpinbofangCountType">
							<div class="count_title">音频播放总数</div>
							<div class="count_num">{{yinpinbofangCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
		<div class="card_list">
			<el-collapse-transition v-if="btnAuth('shipinbofang','首页统计')">
				<el-card v-show="cardTypeList.closeshipinbofangChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								视频播放
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenshipinbofangChartType1')" class="showIcons"
									:class="cardTypeList.hiddenshipinbofangChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeshipinbofangChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenshipinbofangChartType1">
							<div id="shipinbofangxiqufenleiEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('yinpinbofang','首页统计')">
				<el-card v-show="cardTypeList.closeyinpinbofangChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								音频播放
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenyinpinbofangChartType1')" class="showIcons"
									:class="cardTypeList.hiddenyinpinbofangChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeyinpinbofangChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenyinpinbofangChartType1">
							<div id="yinpinbofangxiqufenleiEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closeshipinbofangCountType = true
		countTypeList.value.hiddenshipinbofangCountType = true
		if(btnAuth('shipinbofang','首页总数')){
			getshipinbofangCount()
		}
		countTypeList.value.closeyinpinbofangCountType = true
		countTypeList.value.hiddenyinpinbofangCountType = true
		if(btnAuth('yinpinbofang','首页总数')){
			getyinpinbofangCount()
		}
	}
	const shipinbofangCount = ref(0)
	const getshipinbofangCount = () => {
		context?.$http({
			url:'shipinbofang/count',
			method: 'get'
		}).then(res=>{
			shipinbofangCount.value = res.data.data
		})
	}
	const yinpinbofangCount = ref(0)
	const getyinpinbofangCount = () => {
		context?.$http({
			url:'yinpinbofang/count',
			method: 'get'
		}).then(res=>{
			yinpinbofangCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	const init=()=>{
		getCountList()
		getCardList()
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	let echarts = inject("echarts")
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getCardList()
		},1000)
	}
	const cardTypeList = ref({
		closeshipinbofangChartType1: true,
		hiddenshipinbofangChartType1: true,
		closeyinpinbofangChartType1: true,
		hiddenyinpinbofangChartType1: true,
	})
	const getCardList = () => {
		if(btnAuth('shipinbofang','首页统计')){
			getshipinbofangChart1()
		}
		if(btnAuth('yinpinbofang','首页统计')){
			getyinpinbofangChart1()
		}
	}
	const getshipinbofangChart1 = () => {
		nextTick(()=>{
			var xiqufenleiEchart1 = echarts.init(document.getElementById("shipinbofangxiqufenleiEchart1"),'macarons');
			context?.$http({
				url: "shipinbofang/group/xiqufenlei",
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].xiqufenlei);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].xiqufenlei
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '视频类型统计',
                        left: 'center'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left'
                    },
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
                    },
                    series: [
                        {
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: pArray,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
									shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
				xiqufenleiEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				xiqufenleiEchart1.setOption(option);
				//根据窗口的大小变动图表
				xiqufenleiEchart1.resize();
			})
		})
	}
	const getyinpinbofangChart1 = () => {
		nextTick(()=>{
			var xiqufenleiEchart1 = echarts.init(document.getElementById("yinpinbofangxiqufenleiEchart1"),'macarons');
			context?.$http({
				url: "yinpinbofang/group/xiqufenlei",
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].xiqufenlei);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].xiqufenlei
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '音频类型统计',
                        left: 'center'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left'
                    },
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
                    },
                    series: [
                        {
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: pArray,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
									shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
				xiqufenleiEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				xiqufenleiEchart1.setOption(option);
				//根据窗口的大小变动图表
				xiqufenleiEchart1.resize();
			})
		})
	}
	init()
</script>
<style lang="scss">
	.projectTitle{
		padding: 20px 0;
		margin: 20px 0 20px;
		color: #fff;
		font-weight: 500;
		display: flex;
		width: 100%;
		font-size: 24px;
		justify-content: center;
		align-items: center;
		height: auto;
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		padding: 0 0 0px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: flex-start;
		flex-wrap: wrap;
		// 总数card
		.card_view {
			border: 0px solid #eaeaea;
			border-radius: 0;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 30px;
			background: rgba(68,70,79,0.5);
			width: 23%;
			box-sizing: border-box;
			height: auto;
			// card头部
			.el-card__header {
				border: 0px solid #555;
				background: rgba(68,70,79,0);
				width: 100%;
				border-width: 0 0 0px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #999;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon {
							cursor: pointer;
							color: #999;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.count_item{
					padding: 30px;
					text-align: center;
					// 总数标题
					.count_title{
						color: #999;
						font-size: 16px;
						line-height: 2;
					}
					// 总数数字
					.count_num{
						color: #f00;
						font-size: 30px;
						line-height: 2;
					}
				}
			}
		}
	}
	// 首页盒子
	.home_view {
		padding: 0px 20px;
		margin: 0;
		background: url(http://clfile.zggen.cn/20240203/c67dcf19eea04d68bbcfe298e33c6918.png) no-repeat center top / 100% 100% !important;
		width: 100%;
		min-height: 100vh;
		height: auto;
	}
	// 统计图盒子
	.card_list {
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
		// 统计图card
		.card_view {
			border: 0px solid #eaeaea;
			border-radius: 0;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 40px;
			background: rgba(68,70,79,0.5);
			width: 31%;
			box-sizing: border-box;
			height: auto;
			// 头部
			.el-card__header {
				border: 0px solid rgba(68,70,79,1);
				background: rgba(255, 255, 255, 0);
				width: 100%;
				border-width: 0 0 0px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #ccc;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon{
							cursor: pointer;
							color: #999;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.card_item{
					padding: 30px;
					text-align: center;
				}
			}
		}
	}
</style>
