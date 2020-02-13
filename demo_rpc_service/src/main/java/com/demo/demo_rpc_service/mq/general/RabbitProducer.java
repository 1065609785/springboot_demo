package com.demo.demo_rpc_service.mq.general;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springboot_demo
 * @description: 生产者
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:36
 **/
@Component
@Slf4j
public class RabbitProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Object paramMsg) {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
       log.info("[{}] send msg:{}",RabbitConfig.QUEUE_NAME, dateString+"_"+paramMsg.toString());
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, dateString+"_"+paramMsg.toString());
    }
}
