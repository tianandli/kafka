package com.ck567.springboot.kafka.controller;


import com.ck567.springboot.kafka.demo.KafkaProducer;
import com.ck567.springboot.kafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ww
 * @date 2020/9/29 上午10:49
 */
@Slf4j
@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        List list = new ArrayList<>();
        list.add(new Person("张三",10));
        list.add(new Person("李四",20));
        list.add(new Person("王五",30));
        kafkaProducer.send(list);
        return "sucess";
    }
}
