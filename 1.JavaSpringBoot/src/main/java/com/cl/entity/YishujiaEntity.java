package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 艺术家
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-24 22:15:16
 */
@TableName("yishujia")
public class YishujiaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YishujiaEntity() {
		
	}
	
	public YishujiaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 出生地
	 */
					
	private String chushengdi;
	
	/**
	 * 毕业院校
	 */
					
	private String biyeyuanxiao;
	
	/**
	 * 戏曲成就
	 */
					
	private String xiquchengjiu;
	
	/**
	 * 戏曲作品
	 */
					
	private String xiquzuopin;
	
	/**
	 * 个人简介
	 */
					
	private String gerenjianjie;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：出生地
	 */
	public void setChushengdi(String chushengdi) {
		this.chushengdi = chushengdi;
	}
	/**
	 * 获取：出生地
	 */
	public String getChushengdi() {
		return chushengdi;
	}
	/**
	 * 设置：毕业院校
	 */
	public void setBiyeyuanxiao(String biyeyuanxiao) {
		this.biyeyuanxiao = biyeyuanxiao;
	}
	/**
	 * 获取：毕业院校
	 */
	public String getBiyeyuanxiao() {
		return biyeyuanxiao;
	}
	/**
	 * 设置：戏曲成就
	 */
	public void setXiquchengjiu(String xiquchengjiu) {
		this.xiquchengjiu = xiquchengjiu;
	}
	/**
	 * 获取：戏曲成就
	 */
	public String getXiquchengjiu() {
		return xiquchengjiu;
	}
	/**
	 * 设置：戏曲作品
	 */
	public void setXiquzuopin(String xiquzuopin) {
		this.xiquzuopin = xiquzuopin;
	}
	/**
	 * 获取：戏曲作品
	 */
	public String getXiquzuopin() {
		return xiquzuopin;
	}
	/**
	 * 设置：个人简介
	 */
	public void setGerenjianjie(String gerenjianjie) {
		this.gerenjianjie = gerenjianjie;
	}
	/**
	 * 获取：个人简介
	 */
	public String getGerenjianjie() {
		return gerenjianjie;
	}

}
