package com.walmart.interview.ticket.entity;
import java.util.concurrent.ConcurrentHashMap;

//@Service("TicketingSystem")
public class TicketingSystem {
	
	private volatile static TicketingSystem system = new TicketingSystem();
	
	public final static Integer MAX_CAPACITY=100;
	public final static Integer ROW_CAPACITY=10;
	public final static String[] COLUMN_IDS= {"A","B","C","D","E","F","G","H","I","J"};
	
	public volatile ConcurrentHashMap<String, Seat> seatSlot = new ConcurrentHashMap<String, Seat>();

	public volatile Integer emptySeat=MAX_CAPACITY;
	
	private TicketingSystem() {
		//seatSlot = new ConcurrentHashMap<String, Seat>(MAX_CAPACITY.intValue());
	}
	
	public static TicketingSystem getInstance() {
		//system.seatSlot = new ConcurrentHashMap<String, Seat>(MAX_CAPACITY.intValue());
		for(String s:COLUMN_IDS) {
			for(int i =0;i< ROW_CAPACITY.intValue();i++){
				system.seatSlot.put(s+i, new SeatEmpty(s+i));
				 }
			}
		return system;
	}

}