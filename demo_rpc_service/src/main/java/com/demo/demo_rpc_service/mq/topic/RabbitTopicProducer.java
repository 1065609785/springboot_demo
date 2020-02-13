package com.demo.demo_rpc_service.mq.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springboot_demo
 * @description: 广播模式 生产者
 * @author: zhaoshouyun
 * @create: 2020-01-17 11:36
 **/
@Component
@Slf4j
public class RabbitTopicProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topicTopic1Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        dateString = String.format("[%s] send msg:%s","topic.msg",dateString);
        log.info(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey topic.msg，第三个是你要发送的消息
        // 这条信息将会被 topic.a  topic.b接收
        this.rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE, "topic.msg", dateString);
    }

    public void topicTopic2Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        dateString = String.format("[%s] send msg:%s","topic.good.msg",dateString);
        log.info(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b接收
        this.rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE, "topic.good.msg", dateString);
    }

    public void topicTopic3Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        dateString = String.format("[%s] send msg:%s","topic.m.zhaoshouyun",dateString);
        log.info(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b、topic.b.zhaoshouyun接收
        this.rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE, "topic.m.zhaoshouyun", dateString);
    }
}
