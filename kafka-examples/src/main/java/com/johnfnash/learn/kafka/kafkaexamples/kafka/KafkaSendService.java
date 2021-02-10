package com.johnfnash.learn.kafka.kafkaexamples.kafka;

import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.MessageDTO;
import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.SendResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Kafka 数据发送
 * @author Nash
 */
@EnableBinding({ KafkaOutputSource.class })
public class KafkaSendService implements KafkaOutput {

    @Autowired
    private KafkaOutputSource kafkaOutputSource;

    /**
     * 发送默认消息
     *
     * @param data
     */
    public SendResultDTO sendDefaultMsg(MessageDTO data) {
        return send(kafkaOutputSource.defaultOutput(), data);
    }

    /**
     * 发送预警消息
     *
     * @param data
     */
    public SendResultDTO sendWarningMsg(MessageDTO data) {
        return send(kafkaOutputSource.alarmOutput(), data);
    }

}
