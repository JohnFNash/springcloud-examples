package com.johnfnash.learn.kafka.kafkaexamples.kafka.dto;

import java.util.UUID;

/**
 * kafka DTO 接口
 * 
 * @author nash
 *
 */
public interface KafkaDTOInterface {
	/**
	 * 获取key
	 * 
	 * @return
	 */
	String gainKey();

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	default String gainUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

}
