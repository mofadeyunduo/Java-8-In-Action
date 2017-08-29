package ch12.practice;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class DateTimePractice {

    public void localDate() {
        LocalDate date = LocalDate.of(2017, 8, 28);
        System.out.println(date.toString());

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(String.format("%s %s %s", year, month, day));

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate parse = LocalDate.parse("2017-08-28");
        System.out.println(parse);

        System.out.println();
    }

    public void localTime() {
        LocalTime time = LocalTime.of(20, 30, 40);
        System.out.println(time.toString());

        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(String.format("%s %s %s", hour, minute, second));

        LocalTime parse = LocalTime.parse("12:40:12");
        System.out.println(parse);

        System.out.println();
    }

    public void temporalField() {
        LocalDate now = LocalDate.now();
        System.out.println(String.format("%s %s %s", now.get(ChronoField.YEAR), now.get(ChronoField.MONTH_OF_YEAR), now.get(ChronoField.DAY_OF_MONTH)));

        System.out.println();
    }

    public void localDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2017, 3, 8, 12, 23, 24);
        System.out.println(dateTime);

        LocalDate date = LocalDate.of(2017, 8, 28);
        LocalTime time = LocalTime.of(20, 30, 40);
        dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        LocalDateTime now = LocalDateTime.now();
        LocalDate nowDate = now.toLocalDate();
        LocalTime nowTime = now.toLocalTime();
        System.out.println(nowDate + " " + nowTime);

        System.out.println();
    }

    public void instant() {
        Instant instant = Instant.ofEpochMilli(3000);
        System.out.println(instant.getEpochSecond());

        System.out.println();
    }

    public void duration() {
        Duration duration = Duration.between(LocalTime.of(20, 30, 00), LocalTime.of(20, 31, 30));
        System.out.println(duration.getSeconds());

        System.out.println();
    }

    public void period() {
        Period period = Period.between(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 12, 31));
        System.out.println(period.getMonths());

        System.out.println();
    }

    public void with() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime plusOneDay = now.plusDays(1);
        System.out.println(plusOneDay);

        LocalDateTime withYear2012 = now.withYear(2012);
        System.out.println(withYear2012);

        LocalDateTime withMonth9 = now.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(withMonth9);

        System.out.println();
    }

    public void temporalAdjusters() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));

        LocalDateTime nextWorkingDay = now.with(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int toAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) toAdd = 3;
            if (dayOfWeek == DayOfWeek.SUNDAY) toAdd = 2;
            return temporal.plus(toAdd, ChronoUnit.DAYS);
        });
        System.out.println(nextWorkingDay);

        System.out.println();
    }

    public void format() {
        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(date.format(DateTimeFormatter.ISO_DATE));

        System.out.println();
    }

    public void dateTimeFormatter() {
        DateTimeFormatter customer = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDateTime.now().format(customer));

        DateTimeFormatter italian = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        System.out.println(LocalDateTime.now().format(italian));

        System.out.println();
    }

    public void zone() {
        LocalDate date = LocalDate.of(2014, Month.AUGUST, 22);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = date.atStartOfDay(zoneId);
        System.out.println(zonedDateTime);

        zoneId = ZoneId.of("Europe/Rome");
        zonedDateTime = date.atStartOfDay(zoneId);
        System.out.println(zonedDateTime);

        System.out.println();
    }

    public void nonISO() {
        LocalDate date = LocalDate.now();
        JapaneseDate japaneseDate = JapaneseDate.from(date);
        System.out.println(japaneseDate);

        ChronoLocalDate now = Chronology.ofLocale(Locale.JAPAN).dateNow();
        System.out.println(now);

        HijrahDate hijrahChronology = HijrahDate.now()
                .with(ChronoField.DAY_OF_WEEK, 1)
                .with(ChronoField.DAY_OF_MONTH, 9);
        System.out.println(IsoChronology.INSTANCE.date(hijrahChronology) + " " + IsoChronology.INSTANCE.date(hijrahChronology.with(TemporalAdjusters.lastDayOfMonth())));

        System.out.println();
    }

    public static void main(String[] args) {
        DateTimePractice practice = new DateTimePractice();

        practice.localDate();
        practice.temporalField();
        practice.localTime();
        practice.localDateTime();
        practice.instant();
        practice.duration();
        practice.period();
        practice.with();
        practice.temporalField();
        practice.temporalAdjusters();
        practice.format();
        practice.dateTimeFormatter();
        practice.zone();
        practice.nonISO();
    }

}
