package model;

import java.util.Date;

public class TerminModel {
	private String title;
	private int message;
	private Date date;
	private long restZeit;

	public TerminModel() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getRestZeit() {
		return restZeit;
	}

	public void setRestZeit(long restZeit) {
		this.restZeit = restZeit;
	}

}
