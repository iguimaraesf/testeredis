package com.guimaraes.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory getFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		return factory;
	}
	
	@Bean
	RedisTemplate<String, Object> getRedisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(getFactory());
		return template;
	}
	
}
