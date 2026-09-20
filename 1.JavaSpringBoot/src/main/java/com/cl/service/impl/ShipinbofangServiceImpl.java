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


import com.cl.dao.ShipinbofangDao;
import com.cl.entity.ShipinbofangEntity;
import com.cl.service.ShipinbofangService;
import com.cl.entity.view.ShipinbofangView;

@Service("shipinbofangService")
public class ShipinbofangServiceImpl extends ServiceImpl<ShipinbofangDao, ShipinbofangEntity> implements ShipinbofangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinbofangEntity> page = this.selectPage(
                new Query<ShipinbofangEntity>(params).getPage(),
                new EntityWrapper<ShipinbofangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinbofangEntity> wrapper) {
		  Page<ShipinbofangView> page =new Query<ShipinbofangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShipinbofangView> selectListView(Wrapper<ShipinbofangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinbofangView selectView(Wrapper<ShipinbofangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShipinbofangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShipinbofangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShipinbofangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
