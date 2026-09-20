package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinpinbofangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinbofangView;


/**
 * 音频播放
 *
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface YinpinbofangService extends IService<YinpinbofangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinpinbofangView> selectListView(Wrapper<YinpinbofangEntity> wrapper);
   	
   	YinpinbofangView selectView(@Param("ew") Wrapper<YinpinbofangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinpinbofangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YinpinbofangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YinpinbofangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YinpinbofangEntity> wrapper);



}

