package com.walmart.interview.ticket.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.walmart.interview.ticket.entity.Seat;
import com.walmart.interview.ticket.entity.SeatBooked;
import com.walmart.interview.ticket.entity.SeatEmpty;
import com.walmart.interview.ticket.entity.SeatHold;
import com.walmart.interview.ticket.entity.TicketingSystem;
import com.walmart.interview.ticket.service.TicketService;

@Component
@Scope("prototype")
public class TicketServiceImpl implements TicketService {

	//@Autowired
	TicketingSystem ts = TicketingSystem.getInstance() ;

	@Override
	public int numSeatsAvailable() {

		return ts.emptySeat;
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		String[] seatArr = new String[numSeats];
		Set<Map.Entry<String, Seat>> entrySet = ts.seatSlot.entrySet();
		for(Map.Entry<String,Seat> e : entrySet)
		{
			for (int i = 0; i < numSeats; i++) {
				if (e.getValue() instanceof SeatEmpty) {
					seatArr[i] = e.getKey();
				}
			}
			if(seatArr.length >=numSeats)
				break;
		}
		Date bookedTime = new Date();
		long bookedCode = System.nanoTime();
		SeatHold sh =  new SeatHold(bookedTime,bookedCode);
		sh.setSeatIds(seatArr);
		for(String s : seatArr) {
			if(null != s)
				ts.seatSlot.put(s,sh);
		}
		ts.emptySeat = ts.emptySeat-numSeats;
		return sh;
	}

	@Override
	public String reserveSeats(String seatHoldId, String customerEmail) {
		SeatBooked sb = new SeatBooked(seatHoldId,customerEmail,new Date(),System.nanoTime());
		ts.seatSlot.put(seatHoldId,sb);
		return String.valueOf(sb.getBookedCode());
	}

}
