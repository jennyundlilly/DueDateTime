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
		this.interval = getRestZeit() < 3600 ? 2000 : 6000;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerminModel other = (TerminModel) obj;
		if (calendar == null) {
			if (other.calendar != null)
				return false;
		} else if (!calendar.equals(other.calendar))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
