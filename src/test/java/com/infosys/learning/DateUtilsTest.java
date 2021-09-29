package com.infosys.learning;

import com.infosys.learning.util.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
public class DateUtilsTest {
    Date date;
    String resultFormat;

    @BeforeEach
    public void init(){
        date = Date.from(LocalDate.of(2021,9,29).atStartOfDay(ZoneId.systemDefault()).toInstant());
        resultFormat = new DateUtils().dateTimeToFormat(date,"yyyyMMMdd");
    }

    @Test
    public void dateTimeFormat_souldSuccess(){
        Assertions.assertEquals("9/29/21, 12:00 AM", resultFormat);
    }

    @Test
    public void dateTimeFormat_souldNotSuccess(){
        Assertions.assertEquals("9/29/20",resultFormat);
    }
}
