package so.lvy.app.gankapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date工具类
 * Created by ping on 2016/4/20.
 */
public class DataUtils {
    private DataUtils() {
    }

    public static StringBuilder toDateString(String  dateString) {
        Date date = stringToDate(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year =calendar.get( calendar.YEAR);
        int month = calendar.get(calendar.MONTH)+1;
        int day = calendar.get(calendar.DAY_OF_MONTH);
        return new StringBuilder(year+"年"+month+"月"+day+"日");
    }
    public static String toDateTimeStr(String  dateString) {
        Date date = stringToDate(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "年" + month + "月" + day + "日";
    }
    public static Date stringToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date de = null;
        try {
            de = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return de;
    }
    public static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) +1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year +"/" + month +"/" +day;
    }

}
