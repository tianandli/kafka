package com.ck567.springboot.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic配置(没有这个配置类也能发过去消息！！！！)
 * kafkaTemplate.send("mytopic", normalMessage)发送消息时，kafka会帮我们自动完成topic的创建工作，但这种情况下创建的topic默认只有一个分区
 * @author ww
 * @date 2020/9/29 下午2:21
 */
@Configuration
public class KafkaInitialConfiguration {
    // 创建一个名为mytopic的Topic并设置分区数为8，分区副本数为2
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("mytopic",8, (short) 2 );
    }

    // 如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("mytopic",10, (short) 2 );
    }
}
