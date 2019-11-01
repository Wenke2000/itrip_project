package cn.itrip.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 处理日期类型变量的工具类
 * @author donghai
 * @version v1.0
 * @since 2017/04/20
 */
public class DateUtil {
    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期字符串格式的集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();

        //处理入住时间
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        //自己的....
        Timestamp   t1=new Timestamp(start.getTime());
        System.out.println(t1.toString()+"入住时间aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


        //退房时间
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);


        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {//入住是时间小于退房时间，入住时间等于退房时间  条件成立
            result.add(tempStart.getTime());//去入住时间放入集合

            tempStart.add(Calendar.DAY_OF_YEAR, 1);//相当于时间加一天

            //自己的....
            //得到入住时间的毫秒数
            Long RuZhuHaoMiaoShu=tempStart.getTimeInMillis();
            Timestamp t2=new Timestamp(RuZhuHaoMiaoShu);
            System.out.println(t2+"加1天后的入住时间bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

        }

        return result;
    }

    /**
     * 根据日期字符串返回日期
     * @param source
     * @param format
     * @return
     * @throws ParseException
     */
    public static final Date parse(String source,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(source);
    }

    /**
     * 根据日期获取格式化的日期字符串
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static final String format(Date date,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

}
