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


import com.cl.dao.DiscussshipinbofangDao;
import com.cl.entity.DiscussshipinbofangEntity;
import com.cl.service.DiscussshipinbofangService;
import com.cl.entity.view.DiscussshipinbofangView;

@Service("discussshipinbofangService")
public class DiscussshipinbofangServiceImpl extends ServiceImpl<DiscussshipinbofangDao, DiscussshipinbofangEntity> implements DiscussshipinbofangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshipinbofangEntity> page = this.selectPage(
                new Query<DiscussshipinbofangEntity>(params).getPage(),
                new EntityWrapper<DiscussshipinbofangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshipinbofangEntity> wrapper) {
		  Page<DiscussshipinbofangView> page =new Query<DiscussshipinbofangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshipinbofangView> selectListView(Wrapper<DiscussshipinbofangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshipinbofangView selectView(Wrapper<DiscussshipinbofangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
