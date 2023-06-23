package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CriminalException;
import com.cims.models.Criminal;
import com.cims.models.CriminalAreaDTO;
import com.cims.models.CriminalPoliceStationDTO;
import com.cims.utility.DBUtil;

public class CriminalDaoImpl implements CriminalDao {

	@Override
	public String addCriminal(String criminalName,int criminalAge,String criminalGender,String criminalAddress,String criminalIdentificationMark) throws CriminalException {
		String message="Criminal not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO CRIMINAL(criminal_name,criminal_age,criminal_gender,criminal_address,criminal_identification_mark) VALUES(?,?,?,?,?)");
			
			ps.setString(1, criminalName);
			ps.setInt(2, criminalAge);
			ps.setString(3, criminalGender);
			ps.setString(4, criminalAddress);
			ps.setString(5, criminalIdentificationMark);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Criminal added successfully.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Criminal> showCriminalDetails() throws CriminalException {

		List<Criminal> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM CRIMINAL ORDER BY CRIMINAL_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("criminal_id");
				String n=rs.getString("criminal_name");
				int age=rs.getInt("criminal_age");
				String g=rs.getString("criminal_gender");
				String add=rs.getString("criminal_address");
				String im=rs.getString("criminal_identification_mark");
				
				Criminal criminal=new Criminal();
				criminal.setCriminalID(id);
				criminal.setCriminalName(n);
				criminal.setCriminalAge(age);
				criminal.setCriminalGender(g);
				criminal.setCriminalAddress(add);
				criminal.setCriminalIdentificationMark(im);
				
				list.add(criminal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<CriminalAreaDTO> SearchCriminalByArea() throws CriminalException {

		List<CriminalAreaDTO> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select cl.criminal_id,cl.criminal_name,cl.criminal_age,cl.criminal_gender,cl.criminal_address,cl.criminal_identification_mark,a.area_name \r\n"
					+ "from criminal cl inner join crime c ON cl.criminal_id=c.criminal_id\r\n"
					+ "inner join area a ON a.area_id=c.area_id\r\n"
					+ "ORDER BY cl.criminal_id;");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("criminal_id");
				String n=rs.getString("criminal_name");
				int age=rs.getInt("criminal_age");
				String g=rs.getString("criminal_gender");
				String add=rs.getString("criminal_address");
				String im=rs.getString("criminal_identification_mark");
				String area=rs.getString("area_name");
				
				CriminalAreaDTO crPsDTO=new CriminalAreaDTO();
				crPsDTO.setCriminalID(id);
				crPsDTO.setCriminalName(n);
				crPsDTO.setCriminalAge(age);
				crPsDTO.setCriminalGender(g);
				crPsDTO.setCriminalAddress(add);
				crPsDTO.setCriminalIdentificationMark(im);
				crPsDTO.setAreaName(area);
				
				list.add(crPsDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<CriminalPoliceStationDTO> SearchCriminalByPoliceStation() throws CriminalException {

		List<CriminalPoliceStationDTO> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select cl.criminal_id,cl.criminal_name,cl.criminal_age,cl.criminal_gender,cl.criminal_address,cl.criminal_identification_mark,ps.ps_name \r\n"
					+ "from criminal cl inner join crime c ON cl.criminal_id=c.criminal_id\r\n"
					+ "inner join police_station ps ON PS.PS_id=c.PS_id\r\n"
					+ "ORDER BY cl.criminal_id;");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("criminal_id");
				String n=rs.getString("criminal_name");
				int age=rs.getInt("criminal_age");
				String g=rs.getString("criminal_gender");
				String add=rs.getString("criminal_address");
				String im=rs.getString("criminal_identification_mark");
				String psName=rs.getString("ps_name");
				
				CriminalPoliceStationDTO crPsDTO=new CriminalPoliceStationDTO();
				crPsDTO.setCriminalID(id);
				crPsDTO.setCriminalName(n);
				crPsDTO.setCriminalAge(age);
				crPsDTO.setCriminalGender(g);
				crPsDTO.setCriminalAddress(add);
				crPsDTO.setCriminalIdentificationMark(im);
				crPsDTO.setPsName(psName);
				
				list.add(crPsDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		
		return list;
	}

}

