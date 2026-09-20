package com.cl.entity.view;

import com.cl.entity.ShipinbofangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 视频播放
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-24 22:15:15
 */
@TableName("shipinbofang")
public class ShipinbofangView  extends ShipinbofangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShipinbofangView(){
	}
 
 	public ShipinbofangView(ShipinbofangEntity shipinbofangEntity){
 	try {
			BeanUtils.copyProperties(this, shipinbofangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
