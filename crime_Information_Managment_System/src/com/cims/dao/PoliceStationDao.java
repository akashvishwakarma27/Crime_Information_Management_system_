package com.cims.dao;

import java.util.*;

import com.cims.exceptions.PoliceStationException;
import com.cims.models.PoliceStation;

public interface PoliceStationDao {
	
	public String addPoliceStation(String psname)throws PoliceStationException;
	public List<PoliceStation> showPoliceStationDetails()throws PoliceStationException;
	
}
