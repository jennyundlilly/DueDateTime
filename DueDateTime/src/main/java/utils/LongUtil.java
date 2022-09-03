package utils;

public class LongUtil {
	/**
	 * 1sec = 1; 1min = sec * 60 = 60; 1std = min * 60 = 3600; 1tag = std * 24 =
	 * 86400
	 */
	public static String secountToString(long sekunden) {
		String tag = "", stunde = "", minute = "", sekunde = "";
		int d = 0, h = 0, m = 0, s = 0; // 1s
		long l = sekunden;

		for (;;) {
			if (l >= 86400) {
				l = l - 86400;
				d++;
			} else if (l >= 3600) {
				l = l - 3600;
				h++;
			} else if (l >= 60) {
				l = l - 60;
				m++;
			} else if (l >= 1) {
				l = l - 1;
				s++;
			} else {
				break;
			}
		}

		if (d > 1) {
			tag = d + " Tage ";
		} else if (d == 1) {
			tag = d + " Tag ";
		}

		if (h > 1) {
			stunde = h + " Stunden ";
		} else if (h == 1) {
			tag = h + " Stunde ";
		}

		if (m > 1) {
			minute = m + " Minuten ";
		} else if (m == 1) {
			minute = m + " Minute ";

		}
		if (s > 1) {
			sekunde = s + " Sekunden";
		} else if (s == 1) {
			sekunde = s + " Sekunden";
		}
		return tag + stunde + minute + sekunde;
	}
}
