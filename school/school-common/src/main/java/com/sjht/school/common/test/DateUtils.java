/*
package com.sjht.school.common.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

*/
/**
 * @author chengtianping
 * @description
 * @date 2018/8/28
 *//*

public class DateUtils {

    public static final String SCHOOL_YEAR = "学年";

    public static final String YEAR = "year";

    public static final String SEMESTER = "semester";

    public static final String YYYY_年_MM_月_DD_日 = "yyyy年MM月dd日";

    public static String getCurrentYearSemester(int currentYear, int currentMonth, String yearOrSemester) {
        String year;
        String semester;
        if(currentMonth >= 1 && currentMonth <= 2) {
            year = currentYear - 1 + "-" + currentYear + SCHOOL_YEAR;
            semester = "1";
        } else if(currentMonth >= 3 && currentMonth <= 8) {
            year = currentYear - 1 + "-" + (currentYear) + SCHOOL_YEAR;
            semester = "2";
        } else {
            year = currentYear + "-" + (currentYear + 1) + SCHOOL_YEAR;
            semester = "1";
        }
        if(StringUtils.equals(YEAR,yearOrSemester)){
            return year;
        }else {
            return semester;
        }
    }

    public static int getCurrentYear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public static int getCurrentMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH )+1;
        return month;
    }

//    public static String dateToString(Date date){
//        DateFormat format = new SimpleDateFormat(YYYY_年_MM_月_DD_日);
//        String dateStr = format.format(date);
//        return dateStr;
//    }

    public static void main(String args[]){
        System.out.println(getCurrentYearSemester(getCurrentYear(),getCurrentMonth(),YEAR));
        System.out.println(getCurrentYearSemester(getCurrentYear(),getCurrentMonth(),SEMESTER));
    }
}*/
