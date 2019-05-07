package com.walmart.interview.ticket.entity;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Customer implements Runnable{

	TicketingApp tta = new TicketingApp();
	
	int numOfTicket;
	String customerEmail;
	
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public TicketingApp getTta() {
		return tta;
	}

	public void setTta(TicketingApp tta) {
		this.tta = tta;
	}

	public int getNumOfTicket() {
		return numOfTicket;
	}

	public void setNumOfTicket(int numOfTicket) {
		this.numOfTicket = numOfTicket;
	}

	@Override
	public void run() {
		SeatHold sh = tta.findAndHoldSeats(numOfTicket, customerEmail);
		// replicating user busy scenario , we can also take input from console to enter something to book ticket within 20 seconds
		long b = System.currentTimeMillis();
		delay();
		long after = System.currentTimeMillis();
		if(after-b < 20000) {
			tta.setSh(sh);
			tta.reserveSeats(sh,numOfTicket,customerEmail);
		}
		
	}
	
	private void delay() {
		Random rand = new Random();
		int n = rand.nextInt(20000);
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			//ToDo
		}
	}

}
