package model;

import java.util.Calendar;

public class TerminModel {
	private String title;
	private String message;
	private Calendar calendar;
	private long restZeit; // Sekunde
	private long interval;

	public TerminModel(String title, String message, Calendar calendar) {
		setTitle(title);
		setMessage(message);
		setCalendar(calendar);
		setRestZeit();
		setInterval();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public long getRestZeit() {
		return restZeit;
	}

	public void setRestZeit() {

		this.restZeit = (getCalendar().getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval() {
		this.interval = getRestZeit() < 3600 ? 3000 : 15000;
	}
}
