package com.demo.demo_rpc_service.mq.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_demo
 * @description:  消费者A
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:40
 **/
@Component
@Slf4j
@RabbitListener(queues = RabbitTopicConfig.QUEUE_NAME_A)
public class RabbitTopicConsumerA {
    @Autowired
    AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void recieved(String msg){
        log.info("[{}]---规则：{}，消费者接受到的消息：{}",RabbitTopicConfig.ROUTING_KEY_A, RabbitTopicConfig.QUEUE_NAME_A,msg);
    }

}
