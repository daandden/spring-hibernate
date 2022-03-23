package com.luv2code.hibernate.demo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {};

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // read a date string and parse/convert to a date
    public static LocalDate parseDate(String dateStr) {
        LocalDate theDate = LocalDate.parse(dateStr, formatter);

        return theDate;
    }

    // read a date and format/convert to a string
    public static String formatDate(LocalDate theDate) {

        String result = null;

        if (theDate != null) {
            result = formatter.format(theDate);
        }

        return result;
    }
}
