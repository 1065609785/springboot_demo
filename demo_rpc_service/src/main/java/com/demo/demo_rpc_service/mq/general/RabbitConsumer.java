package com.demo.demo_rpc_service.mq.general;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_demo
 * @description: 消费者
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:40
 **/
@Component
@Slf4j
@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
public class RabbitConsumer {
    @Autowired
    AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void recieved(String msg){
        log.info("[{}]---消费者接受到的消息：{}",RabbitConfig.QUEUE_NAME,msg);
    }

}
