package com.johnfnash.learn.kafka.kafkaexamples.kafka.config;

import com.johnfnash.learn.kafka.kafkaexamples.kafka.dto.KafkaDTOInterface;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class KafkaConfiguration {
	
	private final int MAX_COUNTER = 10000000;
	private AtomicInteger partitionCounter = new AtomicInteger(0);

	/**
	 * key提取
	 * 
	 * @return
	 */
	@Bean
	public PartitionKeyExtractorStrategy getPartitionKeyExtractorStrategy() {
		PartitionKeyExtractorStrategy keyStrategy = new PartitionKeyExtractorStrategy() {

			@Override
			public Object extractKey(Message<?> message) {
				KafkaDTOInterface dto = (KafkaDTOInterface) message.getPayload();
				return dto.gainKey();
			}
		};
		return keyStrategy;
	}

	/**
	 * 分区选择：见
	 * org.springframework.cloud.stream.binding.MessageConverterConfigurer.getPartitionSelectorStrategy
	 * 如果在配置文件配置：partitionSelectorName，则可以指的分区策略
	 * 
	 * @return
	 */
	@Bean("hashPartitionSelector")
	public PartitionSelectorStrategy hashPartitionSelectorStrategy() {
		PartitionSelectorStrategy partitionSelect = new PartitionSelectorStrategy() {

			@Override
			public int selectPartition(Object key, int partitionCount) {
				partitionCounter.compareAndSet(MAX_COUNTER, 0);
				int counter = partitionCounter.getAndAdd(1);
				return counter % partitionCount;
			}
		};

		return partitionSelect;
	}

}
