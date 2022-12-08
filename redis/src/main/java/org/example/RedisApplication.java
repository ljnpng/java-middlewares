package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Bean
    public RedisAtomicLong redisAtomicLong() {
        return new RedisAtomicLong("clue", getConnectionFactory());
    }

    @Bean
    public RedisConnectionFactory getConnectionFactory() {
        return new LettuceConnectionFactory();

    }
}