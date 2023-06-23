package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cims.exceptions.LoginException;
import com.cims.utility.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public String validateLogin(String username, String password) throws LoginException {
		
		String msg="Login required !";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT COUNT(*) AS CNT FROM LOGIN WHERE USERNAME=? AND PASSWORD=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int c=rs.getInt("cnt");
				if(c==0) {
					msg="Invalid login credentials ! Please login again.";
				}else {
					msg="We have verified your identity. Taking you to the portal..";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}
		
		
		return msg;
				
	}

}
