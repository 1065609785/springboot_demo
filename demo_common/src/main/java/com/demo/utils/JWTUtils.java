package com.demo.utils;

import cn.hutool.core.date.DateUtil;
import com.demo.bean.DemoResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @program: springboot_demo
 * @description: json web token 工具类
 * @author: zhaoshouyun
 * @create: 2020-01-21 14:29
 **/
@Slf4j
public class JWTUtils {

    /***
     * 设置失效时间为1天
     **/
    public static final long expTime = 24 * 60 * 60 * 100;

    /**
     * @Description 生成token
     * @Author zhaoshouyun
     * @Date 2020-01-21 02:40
     * @Param key 秘钥key，不可返回给客户端，该key必须在服务端保存
     * @return java.lang.String
     **/
    public static DemoResult<String> createToken(String key) {
        try {
            long now=System.currentTimeMillis();
            //30秒过期
            long exp= now + expTime;
            JwtBuilder jwtBuilder = Jwts.builder().setId(DateUtil.now())
                    //jwt签发者
                    .setSubject( "all" )
                    //jwt 签发着
                    .setIssuer("spring-boot-demo")
                    //接收jwt的一方
                    .setAudience("demo")
                    //jwt的签发时间
                    .setIssuedAt(new Date())
                    //jwt的过期时间，这个过期时间必须要大于签发时间
                    .setExpiration(new Date(exp) )
                    //定义在什么时间之前，该jwt都是不可用的.
                    //.setNotBefore(null)
                    //设置自定义信息
                    .claim( "roles","admin" )
                    .signWith( SignatureAlgorithm.HS256, key);

            String toke = jwtBuilder.compact();

            return DemoResult.SUCCESS(null,toke);

        }catch (Exception e){
              e.printStackTrace();
              log.error("生产token出现异常：{}",e.getMessage());
              return DemoResult.FAIL("生成token出现异常："+e.getMessage());
        }
    }


    /**
     * @Description 校验token
     * @Author zhaoshouyun
     * @Date 2020-01-21 02:49
     * @Param key
     * @Param token
     * @return java.lang.String
     **/
    public static DemoResult checkToken(String key,String token) {
        try{
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return DemoResult.SUCCESS(claims);
        }catch (Exception e){
            e.printStackTrace();
            log.error("校验token出现异常：{}",e.getMessage());
            return DemoResult.FAIL("校验token出现异常："+e.getMessage());
        }
    }
}
