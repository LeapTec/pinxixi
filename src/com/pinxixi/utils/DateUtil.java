package com.pinxixi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateUtil {
	/**
	 * 时间戳(精确到秒)
	 * 
	 * 转换成日期格式字符串
	 */
	public static String timeStamp2Date(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 时间戳(精确到毫秒)
	 * 
	 * 转换成日期格式字符串
	 */
	public static String timeStamp2Date2(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds)));
	}

	/**
	 * 时间戳(精确到秒)
	 * 
	 * 英式
	 * 
	 * 转换成日期格式字符串
	 */
	public static String timeStamp2Date3(String seconds, boolean flag) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		String format = "d MMM, yyyy";
		if (flag) {
			format = "HH:mm:ss, d MMM, yyyy";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 日期格式字符串转换成时间戳（精确到秒）
	 * 
	 * 字符串日期
	 * 
	 * 如：yyyy-MM-dd HH:mm:ss
	 */
	public static String date2TimeStamp(String date_str, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return String.valueOf(sdf.parse(date_str).getTime() / 1000);
	}

	/**
	 * 日期格式字符串转换成时间戳（精确到毫秒）
	 * 
	 * 字符串日期
	 * 
	 * 如：yyyy-MM-dd HH:mm:ss
	 */
	public static String date2TimeStamp2(String date_str, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return String.valueOf(sdf.parse(date_str).getTime());
	}

	/**
	 * 取得当前时间戳（精确到秒）
	 */
	public static String timeStamp() {
		long time = System.currentTimeMillis();
		String t = String.valueOf(time / 1000);
		return t;
	}

	/**
	 * 取得当前时间戳（精确到毫秒）
	 */
	public static String timeStamp2() {
		long time = System.currentTimeMillis();
		String t = String.valueOf(time);
		return t;
	}

	@Test
	public void t() {
		String timeStamp = timeStamp();
		System.out.println("timeStamp=" + timeStamp); // 运行输出:timeStamp=1470278082
		System.out.println(System.currentTimeMillis());// 运行输出:1470278082980
		// 该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数

		String date = timeStamp2Date3(timeStamp, true);
		System.out.println("date=" + date);// 运行输出:date=2016-08-04 10:34:42

		// String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
		// System.out.println(timeStamp2); // 运行输出:1470278082
		System.out.println(DateUtil.timeStamp2Date(DateUtil.timeStamp(), "yyyy-MM-dd"));
	}

}