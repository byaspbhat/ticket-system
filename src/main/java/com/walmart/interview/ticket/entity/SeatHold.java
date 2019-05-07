package com.walmart.interview.ticket.entity;

import java.util.Date;

public class SeatHold extends Seat {
	
	private	Date bookedTime;
	
	private long bookedCode;
	
	private String[] seatIds;
	
	volatile Long timeLimit = 60L;
	
	public SeatHold(Date bookedTime, long bookedCode) {
		super();
		this.bookedTime = bookedTime;
		this.bookedCode = bookedCode;
	}

	public Date getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(Date bookedTime) {
		this.bookedTime = bookedTime;
	}

	public long getBookedCode() {
		return bookedCode;
	}

	public void setBookedCode(long bookedCode) {
		this.bookedCode = bookedCode;
	}

	public Long getTimeLimit() {
		return timeLimit;
	}

	public String[] getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(String[] seatIds) {
		this.seatIds = seatIds;
	}
	
}
