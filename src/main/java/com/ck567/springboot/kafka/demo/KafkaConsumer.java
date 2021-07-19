package com.ck567.springboot.kafka.demo;

import com.alibaba.fastjson.JSON;

import com.ck567.springboot.kafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

/**
 * @author ww
 * @date 2020/9/29 上午10:43
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = com.ck567.springboot.kafka.demo.KafkaProducer.TOPIC_TEST, groupId = com.ck567.springboot.kafka.demo.KafkaProducer.TOPIC_GROUP1)
    public void topic_test(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("消费者里面的group1接收到了消息，主题是:{},消息是:{}", topic,msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = com.ck567.springboot.kafka.demo.KafkaProducer.TOPIC_TEST, groupId = com.ck567.springboot.kafka.demo.KafkaProducer.TOPIC_GROUP2)
    public void topic_test1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("消费者里面的group2接收到了消息，主题是:{},消息是:{}", topic,msg);
            ack.acknowledge();
        }
    }
}
