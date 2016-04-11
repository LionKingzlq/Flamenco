package com.flamenco.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	
	public static String Date2String(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
	
}
