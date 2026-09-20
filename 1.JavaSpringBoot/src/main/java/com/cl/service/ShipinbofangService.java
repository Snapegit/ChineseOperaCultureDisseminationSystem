package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShipinbofangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinbofangView;


/**
 * 视频播放
 *
 * @author 
 * @email 
 * @date 2024-02-24 22:15:15
 */
public interface ShipinbofangService extends IService<ShipinbofangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinbofangView> selectListView(Wrapper<ShipinbofangEntity> wrapper);
   	
   	ShipinbofangView selectView(@Param("ew") Wrapper<ShipinbofangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinbofangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShipinbofangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShipinbofangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShipinbofangEntity> wrapper);



}

