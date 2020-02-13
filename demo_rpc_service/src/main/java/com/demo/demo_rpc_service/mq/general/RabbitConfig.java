package com.demo.demo_rpc_service.mq.general;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot_demo
 * @description: rabbmit Config
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:34
 **/
@Configuration
public class RabbitConfig {
    /**
     * 定义队列名
     */
    public final static String QUEUE_NAME = "zhaoshouyun_putong";


    /**
     * 定义string队列
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(QUEUE_NAME);
    }
}
