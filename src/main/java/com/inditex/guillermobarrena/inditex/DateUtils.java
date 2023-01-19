package com.inditex.guillermobarrena.inditex;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Timestamp convertDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.SS");
        Date parsedDate = dateFormat.parse(date);
        return new java.sql.Timestamp(parsedDate.getTime());
    }
}
