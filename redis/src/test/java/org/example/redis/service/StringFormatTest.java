package org.example.redis.service;

import org.junit.jupiter.api.Test;

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
        System.out.println(String.format("%05d", 11L));
    }
}