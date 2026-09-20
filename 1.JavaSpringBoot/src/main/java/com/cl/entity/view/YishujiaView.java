package com.cl.entity.view;

import com.cl.entity.YishujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 艺术家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
@TableName("yishujia")
public class YishujiaView  extends YishujiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YishujiaView(){
	}
 
 	public YishujiaView(YishujiaEntity yishujiaEntity){
 	try {
			BeanUtils.copyProperties(this, yishujiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
