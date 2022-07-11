package postgraduate.studyJava.tools;

import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TestTime {
    /**
     * 日期分隔符
     */
    static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");

    public static void main(String[] args) {
        System.out.println(getDayNumByMonth("6", "2022"));
    }
    // 判断某一年中某一个月有多少天
    public static Integer getDayNumByMonth(String month, String year){
        Calendar calendar = Calendar.getInstance();
        // 缺少一个为空的判断
        calendar.setTime(getMonth(year + "-" + month));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static Date getMonth(String dateStr) {
        try{
            return monthFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}