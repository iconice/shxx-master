package com.sjht.school.common.entity;

import com.sjht.school.common.enums.RespCodeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * *********************************************
 * @ClassName: BaseResponse
 * @Description: 响应实体类
 * @Author maojianyun
 * @Date 2019/7/19
 * @Copyright: 2019 重庆数聚汇通信息技术有限公司
 * *********************************************
 */
@ApiModel(value = "BaseResponse", description = "响应实体类")
public class BaseResponse  implements Serializable {

	private static final long serialVersionUID = -7691787254007845804L;

	@ApiModelProperty(name = "code", value = "操作码")
	private Integer code;

	@ApiModelProperty(name = "msg", value = "操作描述")
	private String msg;

	public BaseResponse() {

	}

	public BaseResponse Ok(){
		this.code = RespCodeEnums.SUCCESS_CODE.getCode();
		this.msg = RespCodeEnums.SUCCESS_CODE.getMsg();
		return this;
	}

	public BaseResponse error(){
		this.code = RespCodeEnums.FAILURE_CODE.getCode();
		this.msg = RespCodeEnums.FAILURE_CODE.getMsg();
		return this;
	}
	
	public BaseResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
