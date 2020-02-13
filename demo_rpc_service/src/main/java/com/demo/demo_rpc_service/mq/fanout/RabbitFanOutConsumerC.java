package com.demo.demo_rpc_service.mq.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_demo
 * @description: 广播模式 消费者C
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:40
 **/
@Component
@Slf4j
@RabbitListener(queues = RabbitFanOutConfig.QUEUE_NAME_C)
public class RabbitFanOutConsumerC {
    @Autowired
    AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void recieved(String msg){
        log.info("[{}]---消费者接受到的消息：{}",RabbitFanOutConfig.QUEUE_NAME_C,msg);
    }

}
