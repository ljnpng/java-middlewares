package org.example.redis.service;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringFormatTest {

    @Test
    void testStringFormatWithNumberFormat() {
        NumberFormat nf = new DecimalFormat("00000");
        assertEquals("00001", nf.format(1L));
        assertEquals("00021", nf.format(21L));
    }

    @Test
    void testStringFormatWithFormat() {
        assertEquals("00001", String.format("%05d", 1L));
        System.out.println(String.format("%05d", 1188888L));
    }

    @Test
    void testTrebleOperator() {
        String source = "010010001";
        String result = source.endsWith("0000000")
                ? source.substring(0, 2)
                : source.endsWith("0000") ? source.substring(0, 5)
                : source;

    }
}