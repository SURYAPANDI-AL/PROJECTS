package com.library.login;

public interface LoginViewCallBack {

	void loginSuccess(String userName);

	void loginFail(String errorMessage);

}
