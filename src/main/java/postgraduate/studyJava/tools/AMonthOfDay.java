package postgraduate.studyJava.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 判断某一年中某一个月有多少天
public class AMonthOfDay {
    /**
     * 日期分隔符
     */
    static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");

    public static void main(String[] args) {
        System.out.println(getDayNumByMonth("10", "2022"));
    }
    // 判断某一年中某一个月有多少天
    public static Integer getDayNumByMonth(String month, String year){
        Calendar calendar = Calendar.getInstance();
        // 缺少一个为空的判断
        calendar.setTime(getMonth(year + "-" + month));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static Date getMonth(String dateStr) {
        // 格式化为指定的格式
        try{
            return monthFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}