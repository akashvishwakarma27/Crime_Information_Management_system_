package com.cims.dao;

import com.cims.exceptions.LoginException;

public interface LoginDao {
	
	public String validateLogin(String username,String password)throws LoginException;
}
