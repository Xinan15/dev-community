package com.xinan.community.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
// RedisConfig 在这里首先是一个配置类，通过 @Configuration 注解

public class RedisConfig {
    @Bean
    // 此处定义第三方的 RedisTemplate 作为 Bean 来操作 Redis / 访问数据库
    // 因为 Spring Boot 本身并没有提供 RedisTemplate 的 Bean，所以此处我们需自己定义 RedisTemplate 的 Bean
    // RedisConnectionFactory 是 Spring Boot 提供的 Redis 连接工厂，通过它来获取 Redis 连接
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂，之后即可建立连接
        template.setConnectionFactory(factory);
        // 因为我们程序运行的是 Java 代码，在将 Java 代码存入 Redis 时，需要将 Java 对象进行序列化
        // 因此，我们需要分别配置序列化方式

        // 1. 设置 key 的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 2. 设置 value 的序列化方式 - 使用 JSON 序列化
        template.setValueSerializer(RedisSerializer.json());
        // 3. 设置 hash key 的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 4. 设置 hash value 的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        // 此时，为了使得配置生效，我们需要调用 afterPropertiesSet() 方法
        template.afterPropertiesSet();
        return template;
    }
}
