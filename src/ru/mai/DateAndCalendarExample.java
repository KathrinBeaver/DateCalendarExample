package ru.mai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java.util
 * <p>
 * Date - Unix-time, дата в миллисекундах, которые прошли с 1 января 1970 года
 * Calendar - Григорианский календарь
 * <p>
 * java.text
 * SimpleDateFormat
 * <p>
 * java.time (since Java 8)
 * <p>
 * LocalDate –  дата без времени и временных зон
 * LocalTime – время без даты и временных зон
 * LocalDateTime – дата и время без временных зон
 * ZonedDateTime – дата и время с временной зоной
 * DateTimeFormatter – форматирует даты в строки и наоборот, только для классов java.time
 * Instant – количество секунд с Unix epoch time (полночь 1 января 1970 UTC)
 * Duration – продолжительность в секундах и наносекундах
 * Period – период времени в годах, месяцах и днях
 * TemporalAdjuster – корректировщик дат (к примеру, может получить дату следующего понедельника)
 */
public class DateAndCalendarExample {

    public void useDateExample() {

        /* Get current date-time. Convert Date to String*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateStr = sdf.format(new Date());
        System.out.println(dateStr);

        /* Convert String to Date */
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        try {
            Date date = sdf1.parse(dateInString);
            System.out.println(date);
        } catch (ParseException ex) {
            System.out.println("Некорректные данные");
        }
    }

    public void useCalendarExample() {
        SimpleDateFormat sdf1 =
                new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013, Calendar.DECEMBER, 31);
        System.out.println(sdf1.format(calendar.getTime()));

        /* Get current date */
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(sdf1.format(calendar1.getTime()));
    }

    public static void wordWithCalendarExample() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        Calendar calendar =
                new GregorianCalendar(2022, Calendar.FEBRUARY, 28, 13, 24, 56);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        System.out.println(sdf.format(calendar.getTime()));

        System.out.println("year \t\t: " + year);
        System.out.println("month \t\t: " + month);
        System.out.println("dayOfMonth \t: " + dayOfMonth);
        System.out.println("dayOfWeek \t: " + dayOfWeek);
        System.out.println("weekOfYear \t: " + weekOfYear);
        System.out.println("weekOfMonth \t: " + weekOfMonth);

        System.out.println("hour \t\t: " + hour);
        System.out.println("hourOfDay \t: " + hourOfDay);
        System.out.println("minute \t\t: " + minute);
        System.out.println("second \t\t: " + second);
        System.out.println("millisecond \t: " + millisecond);
    }

    public static void setDateManually() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        Calendar calendar =
                new GregorianCalendar(2022, 1, 28, 13, 24, 56);
        System.out.println("#1. "
                + sdf.format(calendar.getTime()));

        //update a date
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.MINUTE, 33);
        System.out.println("#2. " +
                sdf.format(calendar.getTime()));
    }

    public static void substractDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy MMM dd");

        Calendar calendar = new GregorianCalendar(2013, 10, 28);
        System.out.println("Date : "
                + sdf.format(calendar.getTime()));

        //add one month
        calendar.add(Calendar.MONTH, 1);
        System.out.println("Date : " +
                sdf.format(calendar.getTime()));

        //subtract 10 days
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        System.out.println("Date : "
                + sdf.format(calendar.getTime()));

        if (calendar.before(new GregorianCalendar())) {
            System.out.println("Дата меньше текущей");
        } else {
            System.out.println("Дата больше текущей");
        }
    }

    /**
     * Since Java 8
     */
    public void someNewDateClasses() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);
        long timeStampMillis = instant.toEpochMilli();
        System.out.println(timeStampMillis);
    }
}
