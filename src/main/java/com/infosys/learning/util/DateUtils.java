package com.infosys.learning.util;

import com.infosys.learning.dto.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public String dateTimeToFormat(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        return dateFormat.format(date);
    }
}
