package com.johnfnash.learn.kafka.kafkaexamples.action;

import com.johnfnash.learn.kafka.kafkaexamples.kafka.KafkaSendService;
import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 * @author xiaocong.xu
 * @create 2021-01-31
 */
@RestController
public class TestAction {

    @Autowired
    private KafkaSendService kafkaSendService;

    @GetMapping(value = "/test1", produces = "application/json;charset=UTF-8")
    public void test1(@RequestParam("message") String message) {
        MessageDTO dto = MessageDTO.build(message);
        kafkaSendService.sendDefaultMsg(dto);
        kafkaSendService.sendDefaultMsg(dto);
        kafkaSendService.sendDefaultMsg(dto);
        kafkaSendService.sendDefaultMsg(dto);
    }

    @GetMapping(value = "/test2", produces = "application/json;charset=UTF-8")
    public void test2(@RequestParam("message") String message) {
        MessageDTO dto = MessageDTO.build(message);
        kafkaSendService.sendWarningMsg(dto);
        kafkaSendService.sendWarningMsg(dto);
        kafkaSendService.sendWarningMsg(dto);
        kafkaSendService.sendWarningMsg(dto);
    }

}
