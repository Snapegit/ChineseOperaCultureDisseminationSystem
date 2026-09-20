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

import com.cl.entity.YinpinbofangEntity;
import com.cl.entity.view.YinpinbofangView;

import com.cl.service.YinpinbofangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 音频播放
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
@RestController
@RequestMapping("/yinpinbofang")
public class YinpinbofangController {
    @Autowired
    private YinpinbofangService yinpinbofangService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinpinbofangEntity yinpinbofang,
		HttpServletRequest request){
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();

		PageUtils page = yinpinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinbofang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinpinbofangEntity yinpinbofang, 
		HttpServletRequest request){
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();

		PageUtils page = yinpinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinbofang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinpinbofangEntity yinpinbofang){
       	EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinpinbofang, "yinpinbofang")); 
        return R.ok().put("data", yinpinbofangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinpinbofangEntity yinpinbofang){
        EntityWrapper< YinpinbofangEntity> ew = new EntityWrapper< YinpinbofangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinpinbofang, "yinpinbofang")); 
		YinpinbofangView yinpinbofangView =  yinpinbofangService.selectView(ew);
		return R.ok("查询音频播放成功").put("data", yinpinbofangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinpinbofangEntity yinpinbofang = yinpinbofangService.selectById(id);
		yinpinbofang.setClicknum(yinpinbofang.getClicknum()+1);
		yinpinbofang.setClicktime(new Date());
		yinpinbofangService.updateById(yinpinbofang);
		yinpinbofang = yinpinbofangService.selectView(new EntityWrapper<YinpinbofangEntity>().eq("id", id));
        return R.ok().put("data", yinpinbofang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinpinbofangEntity yinpinbofang = yinpinbofangService.selectById(id);
		yinpinbofang.setClicknum(yinpinbofang.getClicknum()+1);
		yinpinbofang.setClicktime(new Date());
		yinpinbofangService.updateById(yinpinbofang);
		yinpinbofang = yinpinbofangService.selectView(new EntityWrapper<YinpinbofangEntity>().eq("id", id));
        return R.ok().put("data", yinpinbofang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinpinbofangEntity yinpinbofang, HttpServletRequest request){
    	yinpinbofang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinpinbofang);
        yinpinbofangService.insert(yinpinbofang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinpinbofangEntity yinpinbofang, HttpServletRequest request){
    	yinpinbofang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinpinbofang);
        yinpinbofangService.insert(yinpinbofang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinpinbofangEntity yinpinbofang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinpinbofang);
        yinpinbofangService.updateById(yinpinbofang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinpinbofangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YinpinbofangEntity yinpinbofang, HttpServletRequest request,String pre){
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yinpinbofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinbofang), params), params));
        return R.ok().put("data", page);
    }





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        List<Map<String, Object>> result = yinpinbofangService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yinpinbofangService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        List<Map<String, Object>> result = yinpinbofangService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yinpinbofangService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        List<Map<String, Object>> result = yinpinbofangService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YinpinbofangEntity yinpinbofang, HttpServletRequest request){
        EntityWrapper<YinpinbofangEntity> ew = new EntityWrapper<YinpinbofangEntity>();
        int count = yinpinbofangService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinbofang), params), params));
        return R.ok().put("data", count);
    }


}
