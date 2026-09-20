package com.cl.dao;

import com.cl.entity.YishujiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishujiaView;


/**
 * 艺术家
 * 
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface YishujiaDao extends BaseMapper<YishujiaEntity> {
	
	List<YishujiaView> selectListView(@Param("ew") Wrapper<YishujiaEntity> wrapper);

	List<YishujiaView> selectListView(Pagination page,@Param("ew") Wrapper<YishujiaEntity> wrapper);
	
	YishujiaView selectView(@Param("ew") Wrapper<YishujiaEntity> wrapper);
	

}
