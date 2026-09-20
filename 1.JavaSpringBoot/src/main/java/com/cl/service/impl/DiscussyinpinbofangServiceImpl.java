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


import com.cl.dao.DiscussyinpinbofangDao;
import com.cl.entity.DiscussyinpinbofangEntity;
import com.cl.service.DiscussyinpinbofangService;
import com.cl.entity.view.DiscussyinpinbofangView;

@Service("discussyinpinbofangService")
public class DiscussyinpinbofangServiceImpl extends ServiceImpl<DiscussyinpinbofangDao, DiscussyinpinbofangEntity> implements DiscussyinpinbofangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinpinbofangEntity> page = this.selectPage(
                new Query<DiscussyinpinbofangEntity>(params).getPage(),
                new EntityWrapper<DiscussyinpinbofangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinpinbofangEntity> wrapper) {
		  Page<DiscussyinpinbofangView> page =new Query<DiscussyinpinbofangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyinpinbofangView> selectListView(Wrapper<DiscussyinpinbofangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinpinbofangView selectView(Wrapper<DiscussyinpinbofangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
