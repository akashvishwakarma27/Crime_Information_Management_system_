package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;
import com.cims.models.CrimeAreaDTO;
import com.cims.models.CrimePoliceStationDTO;
import com.cims.utility.DBUtil;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public String addCrime(String crimeDate, String crimeType, String crimeDetails, String crimeStatus,
			String CrimeSuspect, int criminalID, int areaID, int psID, int victimID) throws CrimeException {

		String message="Crime details not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO CRIME(crime_date,crime_type,"
					+ "crime_details,crime_status,crime_suspect,criminal_id,area_id,ps_id,victim_id) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, crimeDate);
			ps.setString(2, crimeType);
			ps.setString(3, crimeDetails);
			ps.setString(4, crimeStatus);
			ps.setString(5, CrimeSuspect);
			ps.setInt(6, criminalID);
			ps.setInt(7, areaID);
			ps.setInt(8, psID);
			ps.setInt(9, victimID);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Crime details added successfully.";
//				showCrimeDetails();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Crime> showCrimeDetails() throws CrimeException {

		List<Crime> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM CRIME ORDER BY CRIME_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("crime_id");
				String date=rs.getString("crime_date");
				String type=rs.getString("crime_type");				
				String details=rs.getString("crime_details");
				String status=rs.getString("crime_status");
				String suspect=rs.getString("crime_suspect");
				int crid=rs.getInt("criminal_id");
				int aid=rs.getInt("area_id");
				int psid=rs.getInt("ps_id");
				int vid=rs.getInt("victim_id");
				
				Crime crime=new Crime();
				crime.setCrimeID(id);
				crime.setCrimeDate(date);
				crime.setCrimeType(type);
				crime.setCrimeDetails(details);
				crime.setCrimeStatus(status);
				crime.setCrimeSuspect(suspect);
				crime.setCriminalID(crid);
				crime.setAreaID(aid);
				crime.setPsID(psid);
				crime.setVictimID(vid);
				
				list.add(crime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<CrimeAreaDTO> SearchCrimeByArea() throws CrimeException {

		List<CrimeAreaDTO> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement(
					"select c.crime_id,c.crime_date,c.crime_type,c.crime_details,c.crime_status,c.crime_suspect,a.area_name "
					+ "FROM crime c INNER JOIN area a ON c.area_id=a.area_id");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("crime_id");
				String date=rs.getString("crime_date");
				String type=rs.getString("crime_type");				
				String details=rs.getString("crime_details");
				String status=rs.getString("crime_status");
				String suspect=rs.getString("crime_suspect");
				String area=rs.getString("area_name");
				
				CrimeAreaDTO cpsDTO=new CrimeAreaDTO();
				cpsDTO.setCrimeID(id);
				cpsDTO.setCrimeDate(date);
				cpsDTO.setCrimeType(type);
				cpsDTO.setCrimeDetails(details);
				cpsDTO.setCrimeStatus(status);
				cpsDTO.setCrimeSuspect(suspect);
				cpsDTO.setAreaName(area);
				
				list.add(cpsDTO);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return list;
			
	}

	@Override
	public List<CrimePoliceStationDTO> SearchCrimeByPoliceStation() throws CrimeException {

		List<CrimePoliceStationDTO> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement(
					"select c.crime_id,c.crime_date,c.crime_type,c.crime_details,c.crime_status,c.crime_suspect,ps.ps_name "
					+ "FROM crime c INNER JOIN police_station ps ON c.ps_id=ps.ps_id");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("crime_id");
				String date=rs.getString("crime_date");
				String type=rs.getString("crime_type");				
				String details=rs.getString("crime_details");
				String status=rs.getString("crime_status");
				String suspect=rs.getString("crime_suspect");
				String psname=rs.getString("ps_name");
				
				CrimePoliceStationDTO cpsDTO=new CrimePoliceStationDTO();
				cpsDTO.setCrimeID(id);
				cpsDTO.setCrimeDate(date);
				cpsDTO.setCrimeType(type);
				cpsDTO.setCrimeDetails(details);
				cpsDTO.setCrimeStatus(status);
				cpsDTO.setCrimeSuspect(suspect);
				cpsDTO.setPsName(psname);
				
				list.add(cpsDTO);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public String checkStatusByCrimeID(int id) throws CrimeException {
		
		String s=null;
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select crime_status from crime where crime_id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				s=rs.getString("crime_status");
			}else {
				throw new CrimeException("Crime does not exist with id "+id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return s;
	}

	@Override
	public String updateCrimeStatusByCrimeID(String status,int id) throws CrimeException {
		
		String s=null;
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("update crime set crime_status=? where crime_id=?");
			
			ps.setString(1, status);
			ps.setInt(2, id);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				s="status updated successfully....!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return s;
	}

	@Override
	public List<String> numberOfSolvedOrUnsolvedCases() throws CrimeException {
		
		List<String> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT CRIME_STATUS, COUNT(CRIME_STATUS) AS statusCount FROM CRIME GROUP BY CRIME_STATUS");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				String count=rs.getString("statusCount");
				String status=rs.getString("crime_status");
				
				
				list.add(status);
				list.add(count);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public int numberOfCrimesRecordedInCurrentMonth() throws CrimeException {

		int crimeCount=0;
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select count(crime_id) as crimeRecord from crime where month(crime_date)=month(sysdate()) and year(crime_date)=year(sysdate())");
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				crimeCount=rs.getInt("crimeRecord");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return crimeCount;
	}
	
}
