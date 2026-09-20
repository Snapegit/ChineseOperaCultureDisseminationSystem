package com.cl.dao;

import com.cl.entity.DiscussyinpinbofangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinpinbofangView;


/**
 * 音频播放评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface DiscussyinpinbofangDao extends BaseMapper<DiscussyinpinbofangEntity> {
	
	List<DiscussyinpinbofangView> selectListView(@Param("ew") Wrapper<DiscussyinpinbofangEntity> wrapper);

	List<DiscussyinpinbofangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinpinbofangEntity> wrapper);
	
	DiscussyinpinbofangView selectView(@Param("ew") Wrapper<DiscussyinpinbofangEntity> wrapper);
	

}
