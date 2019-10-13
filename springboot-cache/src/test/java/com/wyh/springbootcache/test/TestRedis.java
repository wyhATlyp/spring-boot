package com.wyh.springbootcache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootcache.SpringBootCacheMain;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootCacheMain.class})
public class TestRedis {
	
	@Autowired
	private RedisConnectionFactory factory;
	
	@Autowired
	private RedisClusterConfiguration config;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testFactory() {
		System.out.println(factory.getClusterConnection().clusterGetClusterInfo());
	}
	
	@Test
	public void testConfig() {
		config.getClusterNodes().forEach(System.out::println);
		System.out.println(config.getMaxRedirects());
	}
	
	@Test
	public void testSave() {
		redisTemplate.opsForValue().set("name", "张三");
		redisTemplate.opsForValue().set("age", "18");
	}
	
	@Test
	public void testGet() {
		System.out.println(redisTemplate.opsForValue().get("name"));
		System.out.println(redisTemplate.opsForValue().get("age"));		
	}
	
	@Test
	public void testSaveObject() {
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
		redisTemplate.opsForValue().set("user1", new User("张三", 18));
		redisTemplate.opsForValue().set("user2", new User("李四", 28));
	}
	
	@Test
	public void testGetObject() {
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
		System.out.println(redisTemplate.opsForValue().get("user1"));
		System.out.println(redisTemplate.opsForValue().get("user2"));
	}

}

class User {
	
	private String name;
	
	private Integer age;
	
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}
