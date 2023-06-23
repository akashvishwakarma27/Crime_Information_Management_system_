package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.VictimException;
import com.cims.models.Victim;
import com.cims.utility.DBUtil;

public class VictimDaoImpl implements VictimDao {

	@Override
	public String addVictim(String victimName,int victimAge,String victimGender) throws VictimException {
		String message="Victim not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO VICTIM(victim_name,victim_age,victim_gender) VALUES(?,?,?)");
			
			ps.setString(1, victimName);
			ps.setInt(2, victimAge);
			ps.setString(3, victimGender);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Victim added successfully.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new VictimException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Victim> showVictimDetails() throws VictimException {

		List<Victim> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM VICTIM ORDER BY VICTIM_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("victim_id");
				String n=rs.getString("victim_name");
				int age=rs.getInt("victim_age");
				String g=rs.getString("victim_gender");
				
				Victim victim=new Victim();
				victim.setVictimID(id);
				victim.setVictimName(n);
				victim.setVictimAge(age);
				victim.setVictimGender(g);
				
				list.add(victim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VictimException(e.getMessage());
		}
		
		
		return list;
	}

}
