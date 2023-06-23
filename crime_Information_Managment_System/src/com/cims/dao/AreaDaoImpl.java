package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.AreaException;
import com.cims.exceptions.PoliceStationException;
import com.cims.models.Area;
import com.cims.utility.DBUtil;

public class AreaDaoImpl implements AreaDao {

	@Override
	public String addArea(String areaName) throws AreaException {
		
		String message="Area not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO AREA(AREA_NAME) VALUES(?)");
			
			ps.setString(1, areaName);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Area added successfully.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AreaException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Area> showAreaDetails() throws AreaException {
		
		List<Area> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM AREA ORDER BY AREA_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("area_id");
				String n=rs.getString("area_name");
				
				Area area=new Area();
				area.setAreaID(id);
				area.setAreaName(n);
				
				list.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AreaException(e.getMessage());
		}
		
		
		return list;
	}
	
	
}
