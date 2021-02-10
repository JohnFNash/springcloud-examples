package com.johnfnash.learn.kafka.kafkaexamples.kafka;

import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.MessageDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * kafka消息接收
 * @author Nash
 */
@EnableBinding(value = {KafkaInput.class})
public class KafkaReceiveService {

    /**
     * 默认消息
     *
     * @param defaultMsg
     */
    @StreamListener(KafkaInput.DEFAULT_INPUT)
    public void onDefaultMsg(MessageDTO defaultMsg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date())+"------start--------默认消息：" + defaultMsg);
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date())+"------end--------默认消息");
    }


    /**
     * 预警消息
     *
     * @param warningMsg
     */
    @StreamListener(KafkaInput.ALARM_INPUT)
    public void onAlarmMsg(MessageDTO warningMsg) {
        System.out.println("告警消息：" + warningMsg);
    }

}
