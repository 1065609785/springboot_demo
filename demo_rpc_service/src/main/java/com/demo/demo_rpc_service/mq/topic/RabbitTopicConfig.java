package com.demo.demo_rpc_service.mq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot_demo
 * @description: topic模式也称为主题模式，其实他相对于routing模式最大的好处就是他多了一种匹配模式的路由，怎么理解匹配呢，其实就相当于我们之前正则的.*这种，不过他的匹配机制可能不是这种，而他的工作流程图如下
 *  *我们先讲一下他的匹配规则吧，其实除了匹配规则外，他的作用就和routing模式一样
 *  * 绑定键binding key也必须是这种形式。以特定路由键发送的消息将会发送到所有绑定键与之匹配的队列中。但绑定键有两种特殊的情况：
 *  * ①*（星号）仅代表一个单词
 *  * ②#（井号）代表任意个单词
 *  * 我们就拿上面的图解释，.orange.能匹配 a.orange.a,b.orange.a，aa.orange.bb等等
 *  * lay.#能匹配的就多了，他只要一lay.开头的都匹配，他可以匹配lay.a,lay.a.b,lay.b.c等。
 *  * 这样是不是很方便，比如我们想将log的发给q1队列，其他的发给q2，那么我们只需要定义log.#、或者log.*,那么你发送给q1队列的数据就是log日志的消息。
 *  * 所以这种方式对于处理一个分类的消息特别方便。
 * @author: zhaoshouyun
 * @create: 2020-01-17 13:17
 **/
@Configuration
public class RabbitTopicConfig {
    /**
     * 定义队列名A
     */
    public final static String QUEUE_NAME_A = "queue_zhaoshouyun_Topic_A";
    /**
     * 定义队列名B
     */
    public final static String QUEUE_NAME_B = "queue_zhaoshouyun_Topic_B";
    /**
     * 定义队列名C
     */
    public final static String QUEUE_NAME_C = "queue_zhaoshouyun_Topic_C";
    /**
     * 定义交换机名C
     */
    public final static String TOPIC_EXCHANGE = "zhaoshouyun_TopicExchange";




    /**
     * 路由规则 key A  topicA的key为topic.msg 那么他只会接收包含topic.msg的消息
     */
    public final static String ROUTING_KEY_A = "topic.msg";
    /**
     * 路由规则 key B topicB的key为topic.#那么他只会接收topic开头的消息
     */
    public final static String ROUTING_KEY_B = "topic.#";
    /**
     * 路由规则 key C topicC的key为topic.*.zhaoshouyun那么他只会接收类似topic.B.zhaoshouyun这样格式的消息
     */
    public final static String ROUTING_KEY_C = "topic.*.zhaoshouyun";


   //队列名A 实例
    @Bean
    public Queue queueTopicA(){
        return new Queue(QUEUE_NAME_A);
    }

    //队列名B 实例
    @Bean
    public Queue queueTopicB(){
        return new Queue(QUEUE_NAME_B);
    }

    //队列名C 实例
    @Bean
    public Queue queueTopicC(){
        return new Queue(QUEUE_NAME_C);
    }

    /**
     * 定义个Topic交换器
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为TopicExchange的Topic交换器
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 将定义的topicA队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithA() {
        return BindingBuilder.bind(queueTopicA()).to(topicExchange()).with(ROUTING_KEY_A);
    }
    /**
     * 将定义的topicB队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(queueTopicB()).to(topicExchange()).with(ROUTING_KEY_B);
    }

    /**
     * 将定义的topicC队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(queueTopicC()).to(topicExchange()).with(ROUTING_KEY_C);
    }
}
