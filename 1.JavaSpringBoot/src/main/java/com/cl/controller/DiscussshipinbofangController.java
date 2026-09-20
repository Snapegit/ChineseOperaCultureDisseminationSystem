package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussshipinbofangEntity;
import com.cl.entity.view.DiscussshipinbofangView;

import com.cl.service.DiscussshipinbofangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频播放评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
@RestController
@RequestMapping("/discussshipinbofang")
public class DiscussshipinbofangController {
    @Autowired
    private DiscussshipinbofangService discussshipinbofangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshipinbofangEntity discussshipinbofang,
		HttpServletRequest request){
        EntityWrapper<DiscussshipinbofangEntity> ew = new EntityWrapper<DiscussshipinbofangEntity>();

		PageUtils page = discussshipinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinbofang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshipinbofangEntity discussshipinbofang, 
		HttpServletRequest request){
        EntityWrapper<DiscussshipinbofangEntity> ew = new EntityWrapper<DiscussshipinbofangEntity>();

		PageUtils page = discussshipinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinbofang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshipinbofangEntity discussshipinbofang){
       	EntityWrapper<DiscussshipinbofangEntity> ew = new EntityWrapper<DiscussshipinbofangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshipinbofang, "discussshipinbofang")); 
        return R.ok().put("data", discussshipinbofangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshipinbofangEntity discussshipinbofang){
        EntityWrapper< DiscussshipinbofangEntity> ew = new EntityWrapper< DiscussshipinbofangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshipinbofang, "discussshipinbofang")); 
		DiscussshipinbofangView discussshipinbofangView =  discussshipinbofangService.selectView(ew);
		return R.ok("查询视频播放评论表成功").put("data", discussshipinbofangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshipinbofangEntity discussshipinbofang = discussshipinbofangService.selectById(id);
		discussshipinbofang = discussshipinbofangService.selectView(new EntityWrapper<DiscussshipinbofangEntity>().eq("id", id));
        return R.ok().put("data", discussshipinbofang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshipinbofangEntity discussshipinbofang = discussshipinbofangService.selectById(id);
		discussshipinbofang = discussshipinbofangService.selectView(new EntityWrapper<DiscussshipinbofangEntity>().eq("id", id));
        return R.ok().put("data", discussshipinbofang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshipinbofangEntity discussshipinbofang, HttpServletRequest request){
    	discussshipinbofang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshipinbofang);
        discussshipinbofangService.insert(discussshipinbofang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshipinbofangEntity discussshipinbofang, HttpServletRequest request){
    	discussshipinbofang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshipinbofang);
        discussshipinbofangService.insert(discussshipinbofang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshipinbofangEntity discussshipinbofang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshipinbofang);
        discussshipinbofangService.updateById(discussshipinbofang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshipinbofangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshipinbofangEntity discussshipinbofang, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshipinbofangEntity> ew = new EntityWrapper<DiscussshipinbofangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussshipinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinbofang), params), params));
        return R.ok().put("data", page);
    }








}
