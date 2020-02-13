package com.demo.utils;


import com.demo.bean.AESBean;

/**
 * @program: springboot_demo
 * @description: AES 加解密工具类，该类可以后期扩展成AES+RSA
 * @author: zhaoshouyun
 * @create: 2020-01-20 15:13
 **/
public class AESUtil {

    /**
     * AES 加密操作
     * @Author zhaoshouyun
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
       return AESBean.encrypt(content,password);
    }
    /**
     * @Author zhaoshouyun
     * @Description 使用默认密码进行加密
     * @Date 2020-01-20 03:21
     * @Param content 待加密内容
     * @return java.lang.String 返回Base64转码后的加密数据
     **/
    public static String encrypt(String content) {
       return encrypt(content,AESBean.ASSETS_DEV_PWD_FIELD);
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {
        return AESBean.decrypt(content,password);
    }
    /**
     * @Author zhaoshouyun
     * @Description   使用默认密码进行解密
     * @Date 2020-01-20 03:23
     * @Param content
     * @return java.lang.String
     **/
    public static String decrypt(String content) {
        return  decrypt(content,AESBean.ASSETS_DEV_PWD_FIELD);
    }

    public static void main(String[] args) {
        String origin = "my test string";
        String encrypt = AESUtil.encrypt(origin);
        String decrypt = AESUtil.decrypt(encrypt);
        System.out.println(origin);
        System.out.println(encrypt);
        System.out.println(decrypt);
    }

}
