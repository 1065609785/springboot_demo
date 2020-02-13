package com.demo.bean;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @program: springboot_demo
 * @description: 结果封装类
 * @author: zhaoshouyun
 * @create: 2020-01-17 17:45
 **/
@Data
public class DemoResult<T> {

    /**
     *code  0成功  非0均为失败
     **/
    private String code;
    /**
     * msg  失败信息
     **/
    private String msg;
    /**
     * data  数据
     **/
    private T data;

    public DemoResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public DemoResult(String code, T data) {
        this.code = code;
        this.data = data;
    }


    public static <T> DemoResult SUCCESS(String msg, T data){
        return new DemoResult<T>(Constants.SUCCESS,data);
    }
    public static <T> DemoResult SUCCESS(T data){
        return SUCCESS("操作成功",data);
    }
    public static <T> DemoResult SUCCESS(){
        return SUCCESS("操作成功",null);
    }
    public static DemoResult FAIL(){
        return FAIL("操作失败",null);
    }
    public static <T> DemoResult FAIL(String msg){
        return FAIL(msg,null);
    }

    public static <T> DemoResult FAIL(String msg,T data){
        return new DemoResult<T>(Constants.FAIL,msg,data);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("msg", msg)
                .append("data", data)
                .toString();
    }
}
