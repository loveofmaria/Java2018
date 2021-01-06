package reviewOfYesterday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Demo1 {
    //将字符串"2017-08-16"转换为对应的java.sql.Date类对象
    public static void main(String[] args) throws ParseException {
        String dateString = "2017-08-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = sdf.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(dateTime.getTime());
        System.out.println(sqlDate);
        System.out.println(strToSQDate(dateString));
    }

    public static java.sql.Date strToSQDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDate.parse(dateString, formatter).atStartOfDay();
        long localDateTime = LocalDateTime.from(date).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new java.sql.Date(localDateTime);
    }
}
