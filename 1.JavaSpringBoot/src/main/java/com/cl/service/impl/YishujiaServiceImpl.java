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


import com.cl.dao.YishujiaDao;
import com.cl.entity.YishujiaEntity;
import com.cl.service.YishujiaService;
import com.cl.entity.view.YishujiaView;

@Service("yishujiaService")
public class YishujiaServiceImpl extends ServiceImpl<YishujiaDao, YishujiaEntity> implements YishujiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishujiaEntity> page = this.selectPage(
                new Query<YishujiaEntity>(params).getPage(),
                new EntityWrapper<YishujiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishujiaEntity> wrapper) {
		  Page<YishujiaView> page =new Query<YishujiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YishujiaView> selectListView(Wrapper<YishujiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishujiaView selectView(Wrapper<YishujiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
