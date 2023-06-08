package models;

import java.time.LocalDate;

public  class Util {
	
	public static int getDay(String year, String month) {
		LocalDate localDate;
		localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
		return localDate.lengthOfMonth();
	}
}
