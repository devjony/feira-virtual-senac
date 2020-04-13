package br.com.senacrio.feiravirtual.feiravirtual.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Strings {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static Date parseDateTime(String date) {
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date formatDate(Date date) {
		
		String dateString = format.format(date);
		
		return parseDateTime(dateString);
	}
}
