package com.flight_ticket_reservation_system.cancelticket;

import java.util.Scanner;

import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.setupreservation.SetupReservationView;

public class CancelTicketView implements CancelTicketViewCallBack{
	
	private User user;
	private Scanner scanner=new Scanner(System.in);
	private CancelTicketControllerCallBack cancelTicketController;
	public CancelTicketView(){
		cancelTicketController=new CancelTicketController(this);
	}
	public void create(User user) {
		System.out.println("---->Ticket Cancelation Service<----");
		cancelTicket();
	}
	private void cancelTicket() {
//		System.out.println("--->Enter Details<---\npassword:");
//		String pwd=scanner.next();
		System.out.println("TicketId:");
		int id=scanner.nextInt();
		System.out.println("Passenger Name:(same as in ticket)");
		String name=scanner.next();
		System.out.println("Normal (or) Dhakal");
		String type=scanner.next();
		cancelTicketController.cancelTicket(user.getPassword(),id,name,type);
	}
	public void cancelSuccess() {
		
		System.out.println("Ticket cancelation was Success,your money will be credited within three working days.\n");
		SetupReservationView setup=new SetupReservationView();
		setup.create(user);
	}
	public void cancelFailed(String errorMessage) {
		System.out.println(errorMessage);
		cancelTicket();
	}

}
