package com.demo.demo_rpc_service.mq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot_demo
 * @description: MQ 广播模式
 * @author: zhaoshouyun
 * @create: 2020-01-17 13:17
 **/
@Configuration
public class RabbitFanOutConfig {
    /**
     * 定义队列名A
     */
    public final static String QUEUE_NAME_A = "queue_zhaoshouyun_fanout_A";
    /**
     * 定义队列名B
     */
    public final static String QUEUE_NAME_B = "queue_zhaoshouyun_fanout_B";
    /**
     * 定义队列名C
     */
    public final static String QUEUE_NAME_C = "queue_zhaoshouyun_fanout_C";
    /**
     * 定义交换机名C
     */
    public final static String FANOUT_EXCHANGE = "zhaoshouyun_fanoutExchange";

   //队列名A 实例
    @Bean
    public Queue queueFanOutA(){
        return new Queue(QUEUE_NAME_A);
    }

    //队列名B 实例
    @Bean
    public Queue queueFanOutB(){
        return new Queue(QUEUE_NAME_B);
    }

    //队列名C 实例
    @Bean
    public Queue queueFanOutC(){
        return new Queue(QUEUE_NAME_C);
    }

    /**
     * 定义个fanout交换器
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    /**
     * 将定义的queueFanOutA队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithA() {
        return BindingBuilder.bind(queueFanOutA()).to(fanoutExchange());
    }

    /**
     * 将定义的queueFanOutB队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(queueFanOutB()).to(fanoutExchange());
    }

    /**
     * 将定义的queueFanOutC队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(queueFanOutC()).to(fanoutExchange());
    }
}
