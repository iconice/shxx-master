package com.sjht.school.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldStrategy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BaseEntity", description = "通用返回实体模型")
public class BaseEntity implements Serializable {
	public interface add{}

	public interface update{}
	
	
	public static final Integer DELETE_STATUS = 1;//删除状态
	public static final Integer UNDELETE_STATUS = 0;//未删除状态
	@TableId
	@NotNull(message = "id不能为空" , groups = update.class)
	@ApiModelProperty(name = "id", value = "主键id:添加时该值不需要,修改时该值为19位字符串", example = "")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 标识是否删除；0-false,逻辑未删除，1-true逻辑已删除，默认0
	 */
	@ApiModelProperty(name = "deletec", value = "标识是否删除；0-false,逻辑未删除，1-true逻辑已删除，默认0",hidden=true)
	private Integer deletec;
	/**
	 * 默认值为CURRENT_TIMESTAMP，创建时间不会改变
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间",hidden=true)
	private Date createTime;
	/**
	 * 默认值为CURRENT_TIMESTAMP，数据修改后就改变
	 */
	@ApiModelProperty(name = "updateTime", value = "修改时间",hidden=true)
	private Date updateTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "remark", value = "备注",example="\"[{\"ch\":\"\"},{\"en\":\"\"}]\"")
	@TableField(strategy = FieldStrategy.IGNORED)
	private String remark;

	/**
	 * 设置：标识是否删除；0-false,逻辑未删除，1-true逻辑已删除，默认0
	 */
	public void setDeletec(Integer deletec) {
		this.deletec = deletec;
	}

	/**
	 * 获取：标识是否删除；0-false,逻辑未删除，1-true逻辑已删除，默认0
	 */
	public Integer getDeletec() {
		return deletec;
	}

	/**
	 * 设置：默认值为CURRENT_TIMESTAMP，创建时间不会改变
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：默认值为CURRENT_TIMESTAMP，创建时间不会改变
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：默认值为CURRENT_TIMESTAMP，数据修改后就改变
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取：默认值为CURRENT_TIMESTAMP，数据修改后就改变
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}

}
