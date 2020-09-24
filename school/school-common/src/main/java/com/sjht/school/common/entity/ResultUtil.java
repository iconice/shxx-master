package com.sjht.school.common.entity;

import com.sjht.school.common.enums.RespCodeEnums;

import java.io.Serializable;

public class ResultUtil implements Serializable {

    public static BaseResponse OK(){
        return new BaseResponse().Ok();
    }

    public static BaseResponse OK(String msg){
        return new BaseResponse(RespCodeEnums.SUCCESS_CODE.getCode(), msg);
    }

    public static BaseResponse OK(Object o){
        return new ObjectResponse<>().OK(o);
    }

    public static BaseResponse error(){
        return new BaseResponse().error();
    }

    public static BaseResponse error(String msg){
        return new BaseResponse(RespCodeEnums.FAILURE_CODE.getCode(), msg);
    }
}
