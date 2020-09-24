package com.sjht.school.common.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.enums.RespCodeEnums;

/**
 **********************************************
 * @ClassName: DefaultExceptionHandler
 * @Description:自定义异常处理器（全局异常拦截类）
 * @Author maojianyun
 * @Date 2019年9月1日
 * @Copyright: 2019 重庆数聚汇通信息技术有限公司
 **********************************************
 */
@RestControllerAdvice
public class DefaultExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	/**
	 ********************************************************* 
	 * @Title: notFount
	 * @Description: 拦截未知的运行时异常
	 * @Param: e
	 * @Return: BaseResponse
	 * @Author maojianyun
	 **********************************************************
	 */
	@ExceptionHandler(Exception.class)
	public BaseResponse notFount(RuntimeException e) {
		log.error("运行时异常:", e);
		return new BaseResponse(RespCodeEnums.EXCEPTION_CODE.getCode(), RespCodeEnums.EXCEPTION_CODE.getMsg());
	}

	/**
	 *********************************************************
	 * @Title: authenticationException
	 * @Description: 用户名不存在
	 * @Param: e
	 * @Return: BaseResponse
	 * @Author maojianyun
	 **********************************************************
	 */
	@ExceptionHandler(AuthenticationException.class)
	public BaseResponse authenticationException(RuntimeException e) {
		log.error("密码或用户名不存在:", e);
		return new BaseResponse(RespCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), RespCodeEnums.AUTHENTICATION_EXCEPTION.getMsg());
	}

	/**
	 * ********************************************************
	 * @Title: handleException
	 * @Description: 请求不匹配异常：列如post请求的使用get请求
	 * @Param: e
	 * @Return: BaseResponse
	 * @Author maojianyun
	 **********************************************************
	 */
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public BaseResponse handleException(HttpRequestMethodNotSupportedException e) {
		log.error(e.getMessage(), e);
		return new BaseResponse(RespCodeEnums.REQ_METHOD_CODE.getCode(), "不支持' " + e.getMethod() + "'请求");
	}
}