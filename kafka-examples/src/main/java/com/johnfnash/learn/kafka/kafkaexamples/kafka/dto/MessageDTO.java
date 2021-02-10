package com.johnfnash.learn.kafka.kafkaexamples.kafka.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * dto
 * @author nash
 */
public class MessageDTO implements Serializable, KafkaDTOInterface {
    private static final long serialVersionUID = 1L;

    private String groupId;
    private String message;

    private MessageDTO() {
        super();
    }

    /**
     *
     * @param message
     * @return
     */
    public static MessageDTO build(String message) {
        MessageDTO dto = new MessageDTO();
        dto.setMessage(message);
        dto.generateGroupId();
        return dto;
    }

    @Override
    public String gainKey() {
        return generateGroupId();
    }

    /**
     * 生成UUID
     *
     * @return
     */
    private String generateGroupId() {
        if (this.groupId == null) {
            this.groupId = gainUUID();
        }
        return this.groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
