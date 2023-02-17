package com.flight_ticket_reservation_system.login;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class LoginModel implements LoginModelCallBack {
	private LoginModelControllerCallBack loginController;
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController=loginController;
	}
	public void checkCredentialsDb(String userId, String password) {
		Admin adminUser = FlightTicketReservationSystemDataBase.getInstance().checkValidAdmin(userId,password);
		if (adminUser !=null) {
			loginController.loginSuccess(adminUser);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}
	public void addFlight(int flightNumber, String flightName, String source, String destination, Float depatureTime,
			int seats, int thakkalseats) {
		FlightTicketReservationSystemDataBase.getInstance().addFlight(flightNumber,flightName,source,destination,depatureTime,seats,thakkalseats);
		
	}
	@Override
	public boolean addAdmin(long sId,String id, String name, String pwd) {
		// TODO Auto-generated method stub
		return FlightTicketReservationSystemDataBase.getInstance().addAdmin(sId,id,name,pwd);
	}
}
