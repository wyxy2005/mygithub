package god530.com.simpleapp_slide.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
public class TimeUtils {



    public static String getCurrentMonthYear(){
        return dateFormat1.get().format(new Date(System.currentTimeMillis()));
    }

    public static ThreadLocal<SimpleDateFormat> dateFormat1 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM / yyyy");
        }
    };
}
