package com.johnfnash.learn.kafka.kafkaexamples.kafka;

import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.SendResultDTO;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

/**
 * kafka基础发送方法
 * @author xiaocong.xu
 * @create 2021-01-24
 */
public interface KafkaOutput {

    long timeout_in_milliseconds = 10 * 1000L;

    default SendResultDTO send(MessageChannel messageChannel, Object data) {
        boolean result = true;
        try {
            result = messageChannel.send(MessageBuilder.withPayload(data).build(), timeout_in_milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
            return SendResultDTO.of(e);
        }
        return SendResultDTO.of(result);
    }

    default SendResultDTO send(MessageChannel messageChannel, Map<String,Object> header, Object data) {
        boolean result = true;
        try {
            MessageBuilder messageBuilder = MessageBuilder.withPayload(data);
            for (String headerName : header.keySet()) {
                Object headerValue = header.get(headerName);
                messageBuilder.setHeader(headerName, headerValue);
            }
            result = messageChannel.send(messageBuilder.build(), timeout_in_milliseconds);
        } catch (Exception e) {
            return SendResultDTO.of(e);
        }

        return SendResultDTO.of(result);
    }

}
