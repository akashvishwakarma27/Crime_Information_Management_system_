package com.cims.useCases;

import java.util.Scanner;

import com.cims.dao.LoginDao;
import com.cims.dao.LoginDaoImpl;
import com.cims.exceptions.LoginException;
import com.cims.models.Login;

public class LoginUsecase {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	
	private String username;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void validateLogin() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print(ANSI_PURPLE + "Enter Username: " + ANSI_RESET );
		username=sc.next();
		
		System.out.print(ANSI_PURPLE + "Enter Password: " + ANSI_RESET);
		String password=sc.next();
		
		LoginDao dao=new LoginDaoImpl();
		
		try {
			String msg=dao.validateLogin(username, password);
			
			while (! msg.equals("We have verified your identity. Taking you to the portal..")) {
				System.out.println(ANSI_RED +"Invalid credentials. Please try again." + ANSI_RESET);
				System.out.print(ANSI_PURPLE + "Enter Username: " + ANSI_RESET );
				username=sc.next();
				System.out.print(ANSI_PURPLE + "Enter Password: " + ANSI_RESET);
				password=sc.next();
				msg=dao.validateLogin(username, password);
			}
			
			System.out.println(ANSI_GREEN + msg + ANSI_RESET);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
