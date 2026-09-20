package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshipinbofangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinbofangView;


/**
 * 视频播放评论表
 *
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface DiscussshipinbofangService extends IService<DiscussshipinbofangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinbofangView> selectListView(Wrapper<DiscussshipinbofangEntity> wrapper);
   	
   	DiscussshipinbofangView selectView(@Param("ew") Wrapper<DiscussshipinbofangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinbofangEntity> wrapper);
   	

}

