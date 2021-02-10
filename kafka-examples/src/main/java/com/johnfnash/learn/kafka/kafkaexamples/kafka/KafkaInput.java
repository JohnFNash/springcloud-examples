package com.johnfnash.learn.kafka.kafkaexamples.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义信息输入通道
 * @author xiaocong.xu
 * @create 2021-01-24
 */
public interface KafkaInput {

    /**
     * 缺省消息接口通道名称
     */
    String DEFAULT_INPUT = "defaultInput";

    /**
     * 告警消息接收通道名称
     */
    String ALARM_INPUT = "alarmInput";

    @Input(DEFAULT_INPUT)
    MessageChannel defaultInput();

    @Input(ALARM_INPUT)
    MessageChannel alarmInput();

}
