package com.wyh.springbootcache.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Configuration
public class RedisConfig {
	
	@Bean
	public RedisClusterConfiguration config(ClusterConfigurationProperties clusterProperties) {
		return new RedisClusterConfiguration(clusterProperties.getNodes());
	}
	
	@Bean
	public RedisConnectionFactory connectionFactory(RedisClusterConfiguration config) {
        return new JedisConnectionFactory(config);
    }
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}

}

@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
class ClusterConfigurationProperties {
	
	List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

}
