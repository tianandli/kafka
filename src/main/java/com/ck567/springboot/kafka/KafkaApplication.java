package com.ck567.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaApplication {

    public static void main(String[] args) {
        log.info("=================启动开始==================");
        SpringApplication.run(KafkaApplication.class, args);
        log.info("=================启动完成==================");
    }

}
