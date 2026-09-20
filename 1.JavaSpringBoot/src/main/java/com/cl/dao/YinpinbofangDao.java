package com.cl.dao;

import com.cl.entity.YinpinbofangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinbofangView;


/**
 * 音频播放
 * 
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface YinpinbofangDao extends BaseMapper<YinpinbofangEntity> {
	
	List<YinpinbofangView> selectListView(@Param("ew") Wrapper<YinpinbofangEntity> wrapper);

	List<YinpinbofangView> selectListView(Pagination page,@Param("ew") Wrapper<YinpinbofangEntity> wrapper);
	
	YinpinbofangView selectView(@Param("ew") Wrapper<YinpinbofangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinpinbofangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinpinbofangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinpinbofangEntity> wrapper);



}
