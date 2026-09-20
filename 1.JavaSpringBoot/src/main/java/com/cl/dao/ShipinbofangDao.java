package com.cl.dao;

import com.cl.entity.ShipinbofangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinbofangView;


/**
 * 视频播放
 * 
 * @author 
 * @email 
 * @date 2024-02-24 22:15:15
 */
public interface ShipinbofangDao extends BaseMapper<ShipinbofangEntity> {
	
	List<ShipinbofangView> selectListView(@Param("ew") Wrapper<ShipinbofangEntity> wrapper);

	List<ShipinbofangView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinbofangEntity> wrapper);
	
	ShipinbofangView selectView(@Param("ew") Wrapper<ShipinbofangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShipinbofangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShipinbofangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShipinbofangEntity> wrapper);



}
