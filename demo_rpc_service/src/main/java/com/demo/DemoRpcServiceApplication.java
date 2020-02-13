package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan( {"com.demo.dao"} )
//@DubboComponentScan("com.demo.demo_rpc_service.serviceImpl")
//@EnableDubbo
//@EnableAutoConfiguration
@SpringBootApplication
public class DemoRpcServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoRpcServiceApplication.class, args);
	}

}
