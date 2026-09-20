package com.cl.dao;

import com.cl.entity.DiscussshipinbofangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinbofangView;


/**
 * 视频播放评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface DiscussshipinbofangDao extends BaseMapper<DiscussshipinbofangEntity> {
	
	List<DiscussshipinbofangView> selectListView(@Param("ew") Wrapper<DiscussshipinbofangEntity> wrapper);

	List<DiscussshipinbofangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshipinbofangEntity> wrapper);
	
	DiscussshipinbofangView selectView(@Param("ew") Wrapper<DiscussshipinbofangEntity> wrapper);
	

}
