package com.flight_ticket_reservation_system.cancelticket;

import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class CancelTicketModel implements CancelTicketModelCallBack{
	private CancelTicketControllerCallBack cancelTicketController;
	public CancelTicketModel(CancelTicketControllerCallBack cancelTicketController) {
		this.cancelTicketController=cancelTicketController;
	}
	public boolean cancelTicket(String pwd, int id, String name, String type) {
		return FlightTicketReservationSystemDataBase.getInstance().cancelTicket(pwd,id,name,type);
		
	}
	
}
