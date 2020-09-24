package com.sjht.school.common.enums;

/**
 *  返回码
 */
public enum RespCodeEnums {

    EXCEPTION_CODE(100000001, "服务器出错，请联系管理员"),
    REQ_METHOD_CODE(100000002, "不支持该请求方式"),
    SUCCESS_CODE(100000003, "操作成功"),
    FAILURE_CODE(100000004, "操作失败"),
    LONGIN_FAILURE_CODE(100000005, "登录失败"),
    AUTHENTICATION_EXCEPTION(100000006, "账号或密码错误或账号被禁止登录");

    // 返回编码
    private Integer code;
    // 返回描述
    private String msg;

    private RespCodeEnums(Integer code, String msg){
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
    }}
