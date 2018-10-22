package com.sun.config;


import com.sun.common.SysConstants;
import com.sun.listener.ConsumePubTableConfigListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 表配置变更
 */
@Configuration
public class TableConfigChange {
	@Autowired
	private LettuceConnectionFactory lettuceConnectionFactory;

	@Bean
	public ConsumePubTableConfigListener getConsumerRedis() {
		return new ConsumePubTableConfigListener();
	}

	@Bean
	public ChannelTopic appTopic() {
		return new ChannelTopic(SysConstants.TABLE_CONFIG_APP_UPDATE);
	}
//	@Bean
//	public ChannelTopic moduleTopic() {
//		return new ChannelTopic(SysConstants.TABLE_CONFIG_MODULE_UPDATE);
//	}

	@Bean
	public RedisMessageListenerContainer setRedisMessageListenerContainer() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(lettuceConnectionFactory);
		container.addMessageListener(getConsumerRedis()	, appTopic());
//		container.addMessageListener(getConsumerRedis()	, moduleTopic());
		return container;
	}

}
