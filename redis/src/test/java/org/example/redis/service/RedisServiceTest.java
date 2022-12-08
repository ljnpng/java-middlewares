package org.example.redis.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedisServiceTest {

    @Resource
    private RedisService redisService;

    @Test
    void getCount() {
        Long c1 = redisService.getCount();
        Long c2 = redisService.getCount();
        assertEquals(1L, c2 - c1);
    }

    @Test
    void testStringFormat() {
        NumberFormat nf = new DecimalFormat("0000");
        assertEquals("0001", nf.format(1L));
    }
}