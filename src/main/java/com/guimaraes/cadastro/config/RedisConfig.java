package com.guimaraes.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory getFactory() {
		//RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
		JedisConnectionFactory factory = new JedisConnectionFactory();
		return factory;
	}
	
	@Bean
	RedisTemplate<String, Object> getRedisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<?> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
	    ObjectMapper om = new ObjectMapper();
	    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	    //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	    om.activateDefaultTyping(om.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
	    jackson2JsonRedisSerializer.setObjectMapper(om);

	    
		template.setConnectionFactory(getFactory());
	    template.setKeySerializer(redisSerializer);
	    template.setHashKeySerializer(redisSerializer);
	    template.setValueSerializer(jackson2JsonRedisSerializer);
	    template.setHashValueSerializer(jackson2JsonRedisSerializer);
	    /*template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new StringRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());*/
		return template;
	}
	
}
