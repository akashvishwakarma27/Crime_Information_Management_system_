package com.cims.dao;

import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;
import com.cims.models.CrimeAreaDTO;
import com.cims.models.CrimePoliceStationDTO;

public interface CrimeDao {
	
	public String addCrime(String crimeDate,String crimeType,String crimeDetails,
			String crimeStatus,String CrimeSuspect,int criminalID,int areaID,
			int psID,int victimID )throws CrimeException;
	
	public List<Crime> showCrimeDetails()throws CrimeException;
	
	public List<CrimeAreaDTO> SearchCrimeByArea()throws CrimeException;
	
	public List<CrimePoliceStationDTO> SearchCrimeByPoliceStation()throws CrimeException;
	
	public String checkStatusByCrimeID(int id)throws CrimeException;
	
	public String updateCrimeStatusByCrimeID(String status,int id)throws CrimeException;
	
	public List<String> numberOfSolvedOrUnsolvedCases()throws CrimeException;
	
	public int numberOfCrimesRecordedInCurrentMonth()throws CrimeException;
	
}
