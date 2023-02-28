package com.car_parking_management.login;

import com.car_parking_management.dto.User;

public interface LoginModelCallBack {

	boolean addUser(String name, String email, String pwd, long mblno);

	boolean validateAdmin(String name, String pwd);

	User validateUser(String name, String pwd);

}
