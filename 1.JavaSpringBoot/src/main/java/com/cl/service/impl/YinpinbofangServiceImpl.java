package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YinpinbofangDao;
import com.cl.entity.YinpinbofangEntity;
import com.cl.service.YinpinbofangService;
import com.cl.entity.view.YinpinbofangView;

@Service("yinpinbofangService")
public class YinpinbofangServiceImpl extends ServiceImpl<YinpinbofangDao, YinpinbofangEntity> implements YinpinbofangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinpinbofangEntity> page = this.selectPage(
                new Query<YinpinbofangEntity>(params).getPage(),
                new EntityWrapper<YinpinbofangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinpinbofangEntity> wrapper) {
		  Page<YinpinbofangView> page =new Query<YinpinbofangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinpinbofangView> selectListView(Wrapper<YinpinbofangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinpinbofangView selectView(Wrapper<YinpinbofangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YinpinbofangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YinpinbofangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YinpinbofangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
