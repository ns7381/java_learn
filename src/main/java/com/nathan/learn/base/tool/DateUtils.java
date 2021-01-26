package com.nathan.learn.base.tool;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;


/**
 * Jdk1.7的java.util.Date和java.util.Calendar类易用性差，不支持时区，而且他们都不是线程安全的；
 * 用于格式化日期的类DateFormat被放在java.text包中，它是一个抽象类，所以我们需要实例化一个SimpleDateFormat对象来处理日期格式化，
 * 并且DateFormat也是非线程安全，这意味着如果你在多线程程序中调用同一个DateFormat对象，会得到意想不到的结果。
 * 对日期的计算方式繁琐，而且容易出错，因为月份是从0开始的，从Calendar中获取的月份需要加一才能表示当前月份。
 *
 * Java 8的日期和时间类包含LocalDate、LocalTime、Instant、Duration以及Period，这些类都包含在java.time包中
 */
public class DateUtils {

    // 1.1、String -> Date
    @Test
    public void testStringToDate() throws ParseException {
        String dateStr = "2010-05-04 12:34:23";

        //注意format的格式要与日期String的格式相匹配
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        System.out.println(date.toString()); // Tue May 04 12:34:23 CST 2010
    }

    // 1.2、Date -> String
    @Test
    public void testDateToString() {
        Date date = new Date();
        //format的格式可以任意
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");

        String dateStr = sdf.format(date);
        System.out.println(dateStr); //2017/01/15 13:52:05

        dateStr = sdf2.format(date);
        System.out.println(dateStr); // 2017-01-15 13/52/05
    }

    //  2.1 String ->Timestamp
    // 使用Timestamp的valueOf()方法
    @org.junit.Test
    public void testStringToTimestamp() {
        // 注：String的类型必须形如： yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错！！！
        // 如果String为其他格式，可考虑重新解析下字符串，再重组~~
        String tsStr = "2011-05-09 11:49:45";
        Timestamp ts = Timestamp.valueOf(tsStr);  // 2011-05-09 11:49:45.0
        System.out.println(ts);
    }

    //  2.2 Timestamp -> String
    @org.junit.Test
    public void testTimestampToString() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //方法一:优势在于可以灵活的设置字符串的形式。
        String tsStr = sdf.format(ts);
        System.out.println(tsStr);  // 2017-01-15 21:17:04
        //方法二
        tsStr = ts.toString();
        System.out.println(tsStr); // 2017-01-15 21:17:04.7
    }

    // 3.1 Timestamp -> Date
    @org.junit.Test
    public void testTimestampToDate() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = ts;
        System.out.println(date);  // 2017-01-15 21:31:47.801
//        很简单，但是此刻date对象指向的实体却是一个Timestamp，即date拥有Date类的方法，但被覆盖的方法的执行实体在Timestamp中。

        date = new Date(ts.getTime());
        System.out.println(date); // Sun Jan 15 21:31:47 CST 2017
    }

    //    3.2 Date -> Timestamp
    //  父类不能直接向子类转化，可借助中间的long~~~~
    @org.junit.Test
    public void testDateToTimestamp() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println(ts); // 2017-01-15 21:33:32.203
    }






    /**
     * jdk1.8
     * --------------------------------------------------------------------------------------------------------------------
     */
    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();//可以调用静态方法now()来获取当前日期
        LocalDate localDate = LocalDate.of(2017, 1, 4);     // 初始化一个日期：2017-01-04
        int year = localDate.getYear();                     // 年份：2017
        Month month = localDate.getMonth();                 // 月份：JANUARY
        int dayOfMonth = localDate.getDayOfMonth();         // 月份中的第几天：4
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 一周的第几天：WEDNESDAY
        int length = localDate.lengthOfMonth();             // 月份的天数：31
        boolean leapYear = localDate.isLeapYear();          // 是否为闰年：false
    }

    /**
     * LocalTime和LocalDate类似，他们之间的区别在于LocalDate不包含具体时间，而LocalTime包含具体时间，例如：
     */
    @Test
    public void testLocalTime(){
        LocalTime localTime = LocalTime.of(17, 23, 52);     // 初始化一个时间：17:23:52
        int hour = localTime.getHour();                     // 时：17
        int minute = localTime.getMinute();                 // 分：23
        int second = localTime.getSecond();                 // 秒：52
    }

    /**
     * LocalDateTime类是LocalDate和LocalTime的结合体，可以通过of()方法直接创建，
     * 也可以调用LocalDate的atTime()方法或LocalTime的atDate()方法将LocalDate或LocalTime合并成一个LocalDateTime：
     */
    @Test
    public void testLocalDateTime(){
        LocalDateTime ldt1 = LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52);

        LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 4);
        LocalTime localTime = LocalTime.of(17, 23, 52);
        LocalDateTime ldt2 = localDate.atTime(localTime);

        LocalDate date = ldt1.toLocalDate();
        LocalTime time = ldt1.toLocalTime();

    }

    /**
     * Instant用于表示一个时间戳，它与我们常使用的System.currentTimeMillis()有些类似，
     * 不过Instant可以精确到纳秒（Nano-Second），System.currentTimeMillis()方法只精确到毫秒（Milli-Second）。
     * 如果查看Instant源码，发现它的内部使用了两个常量，seconds表示从1970-01-01 00:00:00开始到现在的秒数，nanos表示纳秒部分（nanos的值不会超过999,999,999）。
     * Instant除了使用now()方法创建外，还可以通过ofEpochSecond方法创建：
     */
    @Test
    public void testInstant() {
        Instant now = Instant.now();
        System.out.println(now);
        //ofEpochSecond()方法的第一个参数为秒，第二个参数为纳秒，代码表示从1970-01-01 00:00:00开始后两分钟的10万纳秒的时刻
        Instant instant = Instant.ofEpochSecond(120, 100000);
        System.out.println(instant);
    }

    /**
     * Duration的内部实现与Instant类似，也是包含两部分：seconds表示秒，nanos表示纳秒。
     * 两者的区别是Instant用于表示一个时间戳（或者说是一个时间点），而Duration表示一个时间段，
     * 所以Duration类中不包含now()静态方法。可以通过Duration.between()方法创建Duration对象
     */
    @Test
    public void testDuration(){
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
        Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的小时数
        long minutes = duration.toMinutes();        // 这段时间的分钟数
        long seconds = duration.getSeconds();       // 这段时间的秒数
        long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数

        //Duration对象还可以通过of()方法创建，该方法接受一个时间段长度，和一个时间单位作为参数：
        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);       // 5天
        Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);  // 1000毫秒
    }


    /**
     * Period在概念上和Duration类似，区别在于Period是以年月日来衡量一个时间段，比如2年3个月6天：
     */
    @Test
    public void testPeriod() {
        Period period = Period.of(2, 3, 6);
        // 2017-01-05 到 2017-02-05 这段时间
        //Period对象也可以通过between()方法创建，值得注意的是，由于Period是以年月日衡量时间段，所以between()方法只能接收LocalDate类型的参数
        period = Period.between(
                LocalDate.of(2017, 1, 5),
                LocalDate.of(2017, 2, 5));

    }

    /**
     * Java 8中的日期/时间类都是不可变的，这是为了保证线程安全。当然，新的日期/时间类也提供了方法用于创建对象的可变版本，比如增加一天或者减少一天：
     */
    @Test
    public void testChangeLocalDate() {
        LocalDate date = LocalDate.of(2017, 1, 5);          // 2017-01-05

        LocalDate date1 = date.withYear(2016);              // 修改为 2016-01-05
        LocalDate date2 = date.withMonth(2);                // 修改为 2017-02-05
        LocalDate date3 = date.withDayOfMonth(1);           // 修改为 2017-01-01

        LocalDate date4 = date.plusYears(1);                // 增加一年 2018-01-05
        LocalDate date5 = date.minusMonths(2);              // 减少两个月 2016-11-05
        LocalDate date6 = date.plus(5, ChronoUnit.DAYS);    // 增加5天 2017-01-10

        LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日
        LocalDate date9 = date.with(lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六
    }

    @Test
    public void testFormatLocalDateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20170105
        String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2017-01-05
        String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);    // 14:20:16.998
        String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05
        String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：YYYY年 MMMM DD日 E", Locale.CHINESE)); // 今天是：2017年 一月 05日 星期四

        String strDate6 = "2017-01-05";
        String strDate7 = "2017-01-05 12:30:05";
        LocalDate date = LocalDate.parse(strDate6, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime dateTime1 = LocalDateTime.parse(strDate7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Java 8中的时区操作被很大程度上简化了，新的时区类java.time.ZoneId是原有的java.util.TimeZone类的替代品。
     * ZoneId对象可以通过ZoneId.of()方法创建，也可以通过ZoneId.systemDefault()获取系统默认时区
     */
    @Test
    public void testZoneId(){
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZoneId systemZoneId = ZoneId.systemDefault();

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        ZoneId oldToNewZoneId = TimeZone.getDefault().toZoneId();

        //可以将一个LocalDate、LocalTime或LocalDateTime对象转化为ZonedDateTime对象
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);

        //使用ZoneOffset，它是以当前时间和世界标准时间（UTC）/格林威治时间（GMT）的偏差来计算
        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

    }
}
