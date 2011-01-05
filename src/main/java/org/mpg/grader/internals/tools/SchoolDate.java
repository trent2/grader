package org.mpg.grader.internals.tools;

import java.util.Calendar;

public class SchoolDate {
	public static String getCurrentSchoolYear() {
		String schoolYear;
		int y = Calendar.getInstance().get(Calendar.YEAR);
		// current month is at most july
		if (Calendar.getInstance().get(Calendar.MONTH) <= 6)
			schoolYear = "" + (y - 1) + "/" + y;
		else
			schoolYear = "" + y + "/" + (y + 1);
		return schoolYear;
	}
}
