package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyinpinbofangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinpinbofangView;


/**
 * 音频播放评论表
 *
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface DiscussyinpinbofangService extends IService<DiscussyinpinbofangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinpinbofangView> selectListView(Wrapper<DiscussyinpinbofangEntity> wrapper);
   	
   	DiscussyinpinbofangView selectView(@Param("ew") Wrapper<DiscussyinpinbofangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinpinbofangEntity> wrapper);
   	

}

