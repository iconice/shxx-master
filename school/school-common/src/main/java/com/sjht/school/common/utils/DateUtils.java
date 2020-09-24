package com.sjht.school.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * ***************************************************
 * @ClassName DateUtils
 * @Description 时间工具类
 * @Author maojianyun
 * @Date 2019/10/10 11:57
 * @Version V1.0
 * ****************************************************
 **/
public class DateUtils {

    private static volatile DateUtils  INSTANCE;

    public final String default_datetime_full_format = "yyyy-MM-dd HH:mm:ss";
    public final String default_datetime_format = "yyyy-MM-dd HH:mm";
    public final String year_format = "yyyy";
    public final String year_month_format = "yyyy-MM";
    public final String year_month_day_format = "yyyy-MM-dd";
    public final String year_month_day_format_dot = "yyyy.MM.dd";
    public final String day_format = "dd";
    public final String hour_minute_second_format = "HH:mm:ss";
    public final String time_format = "HH:mm";

    public final String cn_date_format = "yyyy年MM月dd日";
    public final String pure_year_format = "yyyy";
    public final String pure_month_format = "yyyyMM";
    public final String pure_day_format = "yyyyMMdd";
    public final String pure_daytime_format = "yyyyMMddhhmmss";

    public final String date_pattern = "^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$";

    public final String YEAR = "year";
    public final String SEMESTER = "semester";

    private DateUtils(){}

    public static DateUtils getInstance(){
        if (INSTANCE == null) {
            synchronized (DateUtils.class){
                if (INSTANCE == null) {
                    INSTANCE = new DateUtils();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 得到学年或学期
     * @param currentYear 当前年份
     * @param currentMonth 当前月份
     * @param yearOrSemester year-得到学年， semester-得到学期
     * @return String
     */
    public String getCurrentYearSemester(int currentYear, int currentMonth, String yearOrSemester) {
        String year;
        String semester;
        if(currentMonth >= 1 && currentMonth <= 2) {
            year = currentYear - 1 + "-" + currentYear;
            semester = "1";
        } else if(currentMonth >= 3 && currentMonth <= 8) {
            year = currentYear - 1 + "-" + (currentYear);
            semester = "2";
        } else {
            year = currentYear + "-" + (currentYear + 1);
            semester = "1";
        }
        if(StringUtils.equals(YEAR,yearOrSemester)){
            return year;
        }else {
            return semester;
        }
    }

    /**
     * 得到当前年
     * @return int
     */
    public int getCurrentYear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 得到当前月
     * @return int
     */
    public int getCurrentMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH )+1;
        return month;
    }

//    public static void main(String[] args) {
//        DateUtils dateUtils = DateUtils.getInstance();
//        System.err.println(dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.YEAR));
//        System.err.println(dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.SEMESTER));
//    }
}
