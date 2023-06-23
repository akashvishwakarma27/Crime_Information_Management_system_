package com.cims.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cims.exceptions.PoliceStationException;
import com.cims.models.PoliceStation;
import com.cims.utility.DBUtil;

public class PoliceStationDaoImpl implements PoliceStationDao {

	@Override
	public String addPoliceStation(String psname)throws PoliceStationException {
		
		String message="Police Station not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO POLICE_STATION(ps_name) VALUES(?)");
			
			ps.setString(1, psname);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Police Station added successfully.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PoliceStationException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<PoliceStation> showPoliceStationDetails()throws PoliceStationException {
		
		List<PoliceStation> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps1=conn.prepareStatement("SELECT * FROM POLICE_STATION ORDER BY PS_ID");
			
			ResultSet rs=ps1.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("ps_id");
				String n=rs.getString("ps_name");
				
				PoliceStation ps=new PoliceStation();
				ps.setPsID(id);
				ps.setPsName(n);
				
				list.add(ps);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PoliceStationException(e.getMessage());
		}
		
		return list;
	}

}
