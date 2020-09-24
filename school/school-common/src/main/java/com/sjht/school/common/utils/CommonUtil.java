package com.sjht.school.common.utils;

/**
 * ***************************************************
 * @ClassName 公共工具类
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/10 11:48
 * @Version V1.0
 * ****************************************************
 **/
public class CommonUtil {

    private static volatile CommonUtil INSTANCE;

    private CommonUtil(){

    }

    public static CommonUtil getInstance(){
        if (INSTANCE == null) {
            synchronized (CommonUtil.class){
                if (INSTANCE == null) {
                    INSTANCE = new CommonUtil();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

    }

}
