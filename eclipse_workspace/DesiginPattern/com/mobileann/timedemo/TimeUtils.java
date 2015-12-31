package com.mobileann.timedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {


	public static String[] formats = new String[] {
		"yyyy-MM-dd",//0
		"yyyy.MM.dd",//1
		"yyyy-MM-dd HH:mm",//2
		"yyyy-MM-dd HH:mmZ",//3
		"yyyy-MM-dd HH:mm:ss.SSSZ",//4
		"yyyy-MM-dd'T'HH:mm:ss.SSSZ",//5
		"yyyy��MM��dd��" ,// 6
		"yyyy-MM-dd HH:mm:ss" //7    2015-11-13 19:24:50
	};

	/**
	 * ��ȡ��Ӧ��ʽ���ַ���
	 * @param timemillis
	 * @param regex
	 * @return
	 */
	public static String get_formatted_time(long timemillis, String regex) {
		SimpleDateFormat sf = new SimpleDateFormat(regex, Locale.getDefault());
		return sf.format(timemillis);
	}

	public static String get_formatted_time(Date date, String regex) {
		return new SimpleDateFormat(regex, Locale.getDefault()).format(date);
	}

	/**
	 *  ��ȡ��������
	 * @return
	 */
	public static String getToDayDate() {
		return get_formatted_time(new Date(), formats[0]);
//		Date now = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String hehe = dateFormat.format(now);
//		return hehe;
	}

	/**
	 *  ��ȡ��������2 -- yyyy.MM.dd
	 * @return
	 */
	public static String getToDayDate2() {
//		Date now = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat(formats[1]);
//		String hehe = dateFormat.format(now);
//		return hehe;
		return get_formatted_time(new Date(), formats[1]);
	}

	// ��ȡ��������3
	public static String getToDayDate3() {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd��");
//		Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
//		String str = formatter.format(curDate);
//		return str;
		return get_formatted_time(new Date(), formats[6]);
	}

	// ��ȡʱ�������ַ���
	public static String getDateTimeStr(long currentTimeMillis) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTimeMillis));
	}

	/**
	 * ��ȡָ��ʱ���Ӧ�ĺ�����
	 */
	public static long getTimeMillis(String dateStr) {
		try {
			Date date1 = new SimpleDateFormat(formats[7]).parse(dateStr);
			long temp = date1.getTime();// JAVA��ʱ���������13λ
			return temp;
		} catch (ParseException e) {
		}
		return 0;
	}

	/**
	 * ��ʱ���ʽ��
	 */
	public static String timeFormat(int time) {
		return time >= 10 ? "" + time : "0" + time;
	}

	/**
	 * ȡ�õ�ǰ��ʱ���ַ���
	 * <li>����: 2015-11-13 19:24:50 </li>
	 */
	public static String getCurrentTimeString() {
		return get_formatted_time(new Date(), formats[7]);
//		return getCurrentTimeString("-", " ", ":");
	}

	public static String getCurrentTimeString(String dateSp, String sp, String timeSp) {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR) + dateSp + timeFormat(c.get(Calendar.MONTH) + 1) + dateSp + timeFormat(c.get(Calendar.DAY_OF_MONTH)) + sp
				+ timeFormat(c.get(Calendar.HOUR_OF_DAY)) + timeSp + timeFormat(c.get(Calendar.MINUTE)) + timeSp + timeFormat(c.get(Calendar.SECOND));
	}

	/**
	 * ����ʱ��
	 */
	public static String fixTime(String timestamp) {
		if (timestamp == null || "".equals(timestamp)) {
			return "";
		}

		try {
			long _timestamp = Long.parseLong(timestamp) * 1000;
			if (System.currentTimeMillis() - _timestamp < 1 * 60 * 1000) {
				return "�ո�";
			} else if (System.currentTimeMillis() - _timestamp < 30 * 60 * 1000) {
				return ((System.currentTimeMillis() - _timestamp) / 1000 / 60) + "����ǰ";
			} else {
				Calendar now = Calendar.getInstance();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(_timestamp);
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE)) {
					SimpleDateFormat sdf = new SimpleDateFormat("���� HH:mm");
					return sdf.format(c.getTime());
				}
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE) - 1) {
					SimpleDateFormat sdf = new SimpleDateFormat("���� HH:mm");
					return sdf.format(c.getTime());
				} else if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
					SimpleDateFormat sdf = new SimpleDateFormat("M��d�� HH:mm:ss");
					return sdf.format(c.getTime());
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d�� HH:mm:ss");
					return sdf.format(c.getTime());
				}
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static String fixTime(long _timestamp) {
		try {
			if (System.currentTimeMillis() - _timestamp < 1 * 60 * 1000) {
				return "�ո�";
			} else if (System.currentTimeMillis() - _timestamp < 30 * 60 * 1000) {
				return ((System.currentTimeMillis() - _timestamp) / 1000 / 60) + "����ǰ";
			} else {
				Calendar now = Calendar.getInstance();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(_timestamp);
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE)) {
					SimpleDateFormat sdf = new SimpleDateFormat("���� HH:mm");
					return sdf.format(c.getTime());
				}
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR) && c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE) - 1) {
					SimpleDateFormat sdf = new SimpleDateFormat("���� HH:mm");
					return sdf.format(c.getTime());
				} else if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
					SimpleDateFormat sdf = new SimpleDateFormat("M��d�� HH:mm:ss");
					return sdf.format(c.getTime());
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d�� HH:mm:ss");
					return sdf.format(c.getTime());
				}
			}
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * �жϸ����ַ���ʱ���Ƿ�Ϊ����
	 * 
	 * @param sdate
	 * @return boolean
	 */
	public static boolean isToday(long milliseconds) {
		boolean b = false;
		Date time = new Date(milliseconds);
		Date today = new Date();
		if (time != null) {
			String nowDate = dateFormater2.get().format(today);
			String timeDate = dateFormater2.get().format(time);
			if (nowDate.equals(timeDate)) {
				b = true;
			}
		}
		return b;
	}

	private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

}
