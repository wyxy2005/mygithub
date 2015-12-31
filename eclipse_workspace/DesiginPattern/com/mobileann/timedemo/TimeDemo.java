package com.mobileann.timedemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeDemo {


	static String[] formats = new String[] {
			"yyyy-MM-dd",
			"yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mmZ",
			"yyyy-MM-dd HH:mm:ss.SSSZ",
			"yyyy-MM-dd'T'HH:mm:ss.SSSZ",
	};

	public static void main(String[] args) {
		System.out.println("------------------------------------\n");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		String regex = TimeUtils.formats[0];
		String get_formatted_time = TimeUtils.get_formatted_time(currentTimeMillis, regex);
		System.out.println(get_formatted_time);;
		System.out.println("------------------------------------\n");
		for (String format : formats) {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
			System.out.format("%30s %s\n", format, sdf.format(new Date(System.currentTimeMillis())));
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.out.format("%30s %s\n", format, sdf.format(new Date(System.currentTimeMillis())));
		}
		System.out.println("------------------------------------\n");
		System.out.println("getToDayDate  :" + TimeUtils.getToDayDate());
		
		System.out.println("------------------------------------\n");
		System.out.println("getToDayDate2" + TimeUtils.getToDayDate2());
		System.out.println("------------------------------------\n");
		String get_formatted_time2 = TimeUtils.get_formatted_time(new Date(), TimeUtils.formats[7]);
		System.out.println(get_formatted_time2);
		System.out.println(" \nTimeUtils.getTimeMillis(\"\")    "+TimeUtils.getTimeMillis(get_formatted_time2));
		System.out.println("------------------------------------\n");
		System.out.println(TimeUtils.getCurrentTimeString());
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");
		System.out.println("------------------------------------\n");

	}


}
