package com.walmart.interview.ticket.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.walmart.interview.ticket.service.TicketService;
import com.walmart.interview.ticket.service.impl.TicketServiceImpl;

@Component
@Scope("prototype")
public class TicketingApp {

	//@Autowired
	TicketService ts = new TicketServiceImpl();
	
	private SeatHold sh;

	public int numSeatsAvailable() {
		return ts.numSeatsAvailable();
	}

	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		return ts.findAndHoldSeats(numSeats, customerEmail);
	}

	public String reserveSeats(SeatHold sh2, int seatHoldId, String customerEmail) {
		for(String s : sh2.getSeatIds())
			ts.reserveSeats(s, customerEmail);
		
		return sh2.getSeatIds().toString();
	}

	public TicketService getTs() {
		return ts;
	}

	public void setTs(TicketService ts) {
		this.ts = ts;
	}

	public SeatHold getSh() {
		return sh;
	}

	public void setSh(SeatHold sh) {
		this.sh = sh;
	}
	
}
