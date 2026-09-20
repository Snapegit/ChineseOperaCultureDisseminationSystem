package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YishujiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishujiaView;


/**
 * 艺术家
 *
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
public interface YishujiaService extends IService<YishujiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YishujiaView> selectListView(Wrapper<YishujiaEntity> wrapper);
   	
   	YishujiaView selectView(@Param("ew") Wrapper<YishujiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YishujiaEntity> wrapper);
   	

}

