package date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeStudy {
    public static void run(){
        /*
        从Java 8开始，java.time包提供了新的日期和时间API，主要涉及的类型有：

        本地日期和时间：LocalDateTime，LocalDate，LocalTime；
        带时区的日期和时间：ZonedDateTime；
        时刻：Instant；
        时区：ZoneId，ZoneOffset；
        时间间隔：Duration。

         */
        /**
         *  修正了旧API不合理的常量设计：
         *
         *     Month的范围用1~12表示1月到12月；
         *     Week的范围用1~7表示周一到周日。
         */
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        //通过指定的日期和时间创建LocalDateTime可以通过of()方法：

        // 指定日期和时间:
        LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
        LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);
        //DateTimeFormatter
        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));


    }

    public static void run2(){
        //LocalDateTime提供了对日期和时间进行加减的非常简单的链式调用：
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 加5天减3小时:
        LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
        System.out.println(dt2); // 2019-10-31T17:30:59
        // 减1月:
        LocalDateTime dt3 = dt2.minusMonths(1);
        System.out.println(dt3); // 2019-09-30T17:30:59

        /*
        对日期和时间进行调整则使用withXxx()方法，例如：withHour(15)会把10:11:12变为15:11:12：

        调整年：withYear()
        调整月：withMonth()
        调整日：withDayOfMonth()
        调整时：withHour()
        调整分：withMinute()
        调整秒：withSecond()

         */

        /*
        Duration和Period

Duration表示两个时刻之间的时间间隔。另一个类似的Period表示两个日期之间的天数：
         */
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S,表示1235小时10分钟30秒

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D
    }
}

/*
小结

Java 8引入了新的日期和时间API，它们是不变类，默认按ISO 8601标准格式化和解析；

使用LocalDateTime可以非常方便地对日期和时间进行加减，或者调整日期和时间，它总是返回新对象；

使用isBefore()和isAfter()可以判断日期和时间的先后；

使用Duration和Period可以表示两个日期和时间的“区间间隔”。
 */