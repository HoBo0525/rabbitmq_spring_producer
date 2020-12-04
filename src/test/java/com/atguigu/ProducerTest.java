package com.atguigu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Hobo
 * @create 2020-12-04 19:00
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class ProducerTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

//    普通交换机发送消息
    @Test
    public void ProducerTest(){
        rabbitTemplate.convertAndSend("spring_queue", "使用spring配置发送的消息");

    }


//    Fanout交换机发送消息
    @Test
    public void FanoutTest(){
        rabbitTemplate.convertAndSend("spring_fanout1", "","使用spring配置发送的Fanout1消息");
        rabbitTemplate.convertAndSend("spring_fanout2","", "使用spring配置发送的Fanout2消息");

    }


//    Topic交换机发送消息
    @Test
    public void TopicTest(){
        rabbitTemplate.convertAndSend("spring_topic","atguigu.bj","发送到spring_topic_exchange交换机atguigu.bj的消息");
        rabbitTemplate.convertAndSend("spring_topic","atguigu.bj.1","发送到spring_topic_exchange交换机atguigu.bj.1的消息");
        rabbitTemplate.convertAndSend("spring_topic","atguigu.bj.2","发送到spring_topic_exchange交换机atguigu.bj.2的消息");
        rabbitTemplate.convertAndSend("spring_topic","guigu.cn","发送到spring_topic_exchange交换机guigu.cn的消息");
    }
}
