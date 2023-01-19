package com.inditex.guillermobarrena.inditex;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void convertDate() throws ParseException {
        assertEquals(DateUtils.convertDate("2020-06-14-00.00.00").toString(), "2020-06-14 00:00:00.0");
    }
}