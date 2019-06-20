package me.atticusthecoder.bulldog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	public static String getNow() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z"); 
		formatter.setTimeZone(TimeZone.getTimeZone("PST"));
		Date date = new Date(System.currentTimeMillis());  
		return formatter.format(date);
	}
}

