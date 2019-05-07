package com.walmart.interview.ticket.entity;

import java.util.Date;

public class SeatBooked extends Seat {
	
	private String emailId;
	
	private	Date bookedTime;
	
	private long bookedCode;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(Date bookedTime) {
		this.bookedTime = bookedTime;
		this.bookedCode = System.nanoTime();
	}

	public long getBookedCode() {
		return bookedCode;
	}

	public SeatBooked(String id,String emailId, Date bookedTime, long bookedCode) {
		super();
		super.id=id;
		super.ss=SeatStatus.BOOKED;
		this.emailId = emailId;
		this.bookedTime = bookedTime;
		this.bookedCode = bookedCode;
	}
	
}
