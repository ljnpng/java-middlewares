package org.example.redis.service;

import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private RedisAtomicLong redisAtomicLong;

    public Long getCount() {
        return redisAtomicLong.incrementAndGet();
    }




}
