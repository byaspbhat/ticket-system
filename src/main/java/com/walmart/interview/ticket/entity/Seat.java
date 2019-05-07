package com.walmart.interview.ticket.entity;

public abstract class Seat {
	
	protected String id;
	protected SeatStatus ss = SeatStatus.EMPTY;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SeatStatus getSs() {
		return ss;
	}
	public void setSs(SeatStatus ss) {
		this.ss = ss;
	}
	
}
