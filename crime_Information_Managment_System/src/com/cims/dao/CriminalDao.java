package com.cims.dao;

import java.util.List;

import com.cims.exceptions.CriminalException;
import com.cims.models.Criminal;
import com.cims.models.CriminalAreaDTO;
import com.cims.models.CriminalPoliceStationDTO;

public interface CriminalDao {

	public String addCriminal(String criminalName,int criminalAge,String criminalGender,
			String criminalAddress,String criminalIdentificationMark)throws CriminalException;
	
	public List<Criminal> showCriminalDetails()throws CriminalException;
	
	public List<CriminalAreaDTO> SearchCriminalByArea()throws CriminalException;
	
	public List<CriminalPoliceStationDTO> SearchCriminalByPoliceStation()throws CriminalException;
	
}

