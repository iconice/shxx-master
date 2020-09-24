package com.sjht.school.common.entity;
import java.io.Serializable;

import com.sjht.school.common.enums.RespCodeEnums;

import io.swagger.annotations.ApiModel;

/**
 * *********************************************
 * @ClassName: ObjectResponse<T>
 * @Description: 响应实体类
 * @Author maojianyun
 * @Date 2019/7/19
 * @Copyright: 2019 重庆数聚汇通信息技术有限公司
 * *********************************************
 */
@ApiModel(value = "ObjectResponse", description = "响应实体类")
public class ObjectResponse<T> extends BaseResponse implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public  ObjectResponse(){
    }

    public  ObjectResponse(int code, String msg, T data){
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public ObjectResponse rsult(int code, String msg){
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public ObjectResponse<T> OK(T data){
        this.setCode(RespCodeEnums.SUCCESS_CODE.getCode());
        this.setMsg(RespCodeEnums.SUCCESS_CODE.getMsg());
        this.setData(data);
        return this;
    }
}