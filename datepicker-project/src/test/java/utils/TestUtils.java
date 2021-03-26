package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUtils {
    public static void isValidDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String ordinalDayDateFormat(String dateStr) {
        return dateStr.replaceAll("(\\s[23]*1)(,\\s)", "$1st$2")
                .replaceAll("(\\s[2]*2)(,\\s)","$1nd$2")
                .replaceAll("(\\s[2]*3)(,\\s)", "$1rd$2")
                .replaceAll("([2]*[4-9]|[10-20]|30)(,\\s)", "$1th$2");
    }
}