package com.johnfnash.learn.kafka.kafkaexamples.kafka.dto;

/**
 * 发送结果
 *
 */
public class SendResultDTO {
    private boolean success;
    private Throwable exception;

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailed() {
        return !success;
    }

    public Throwable getException() {
        return exception;
    }


    public static SendResultDTO of(boolean result) {
        SendResultDTO dto = new SendResultDTO();
        dto.success = result;
        return dto;
    }

    public static SendResultDTO of(Throwable e) {
        SendResultDTO dto = new SendResultDTO();
        dto.success = false;
        dto.exception = e;
        return dto;
    }
}
