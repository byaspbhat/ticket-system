package com.walmart.interview.ticketsystem;

import java.io.Console;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.interview.ticket.entity.Customer;

public class TicketSystemApplication implements CommandLineRunner{

	static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		//context = SpringApplication.run(TicketSystemApplication.class, args);
		//TicketingSystem ticketingSystem = context.getBean("TicketingSystem",TicketingSystem.class);
		Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("\n ENTER number of Ticket.\n");
				String numOfTicket = sc.next();
				if ("exit".equals(numOfTicket)) {
					sc.close();
					System.exit(0);
				}
				System.out.println("\n ENTER email id.\n");
				String customerEmail = sc.next();
				if (!"exit".equals(numOfTicket) && isInt(numOfTicket)) {
					 int num = Integer.parseInt(numOfTicket);
					IntStream.range(0, 5).forEach(e -> {
						startBooking(e,num,customerEmail);
						
					});
				}
			}
			
	}
	
	private static void startBooking(int e, int num, String customerEmail) {
		Customer customer =new Customer();
		customer.setCustomerEmail(customerEmail);
		customer.setNumOfTicket(num);
		Thread t = new Thread(customer);
		t.start();
		
	}

	private static boolean isInt(String str)
	 {
	     return str.matches("^-?\\d+$");
	 }

	@Override
	public void run(String... args) throws Exception {
		//TicketingSystem ticketingSystem = context.getBean(TicketingSystem.class);
		Console c = System.console();
		if (c != null) {
			while (true) {
				c.format("\nPress ENTER to proceed.\n");
				String numOfTicket = c.readLine();
				String customerEmail = c.readLine();
				if (!"exit".equals(numOfTicket) && isInt(numOfTicket)) {
					 int num = Integer.parseInt(numOfTicket);
					IntStream.range(0, 5).forEach(e -> {
						Customer customer = context.getBean(Customer.class);
						customer.setCustomerEmail(customerEmail);
						customer.setNumOfTicket(num);
						Thread t = new Thread(customer);
						t.start();
					});
				}
			}
		}
		
	}

}
