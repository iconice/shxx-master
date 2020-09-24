package com.sjht.school.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 ********************************************** 
 * @ClassName: PageFom  
 * @Description:查询列表分页请求类 
 * @Author maojianyun  
 * @Date 2019年07月17日
 * @Copyright: 2019 重庆数聚汇通信息技术有限公司
 **********************************************
 */
@ApiModel(value = "PageFom",description = "列表分页请求类")
public class PageBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer limit;

	private Integer offset;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
