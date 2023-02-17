package com.flight_ticket_reservation_system.cancelticket;

public class CancelTicketController implements CancelTicketControllerCallBack,CancelTicketModelControllerCallBack{
	private CancelTicketViewCallBack cancelTicketView;
	private CancelTicketModelCallBack cancelTicketModel;
	public CancelTicketController(CancelTicketViewCallBack cancelTicketView) {
		this.cancelTicketView=cancelTicketView;
		cancelTicketModel=new CancelTicketModel(this);
	}
	public void cancelTicket(String pwd, int id, String name, String type) {
		boolean isCancel=cancelTicketModel.cancelTicket(pwd,id,name,type);
		if(isCancel) {
			cancelTicketView.cancelSuccess();
		}
		else
			cancelTicketView.cancelFailed("Invalid credentials.Please try Again!");
	}

}
