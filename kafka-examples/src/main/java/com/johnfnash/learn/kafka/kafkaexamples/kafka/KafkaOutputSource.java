package com.johnfnash.learn.kafka.kafkaexamples.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义信息输出通道
 * @author xiaocong.xu
 * @create 2021-01-24
 */
public interface KafkaOutputSource {

    /**
     * 缺省发送消息通道名称
     */
    String DEFAULT_OUTPUT = "defaultOutput";

    /**
     * 告警发送消息通道名称
     */
    String ALARM_OUTPUT = "alarmOutput";

    @Output(DEFAULT_OUTPUT)
    MessageChannel defaultOutput();

    @Output(ALARM_OUTPUT)
    MessageChannel alarmOutput();

}
