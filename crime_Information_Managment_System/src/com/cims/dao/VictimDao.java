package com.cims.dao;

import java.util.List;

import com.cims.exceptions.VictimException;
import com.cims.models.Victim;

public interface VictimDao {

	public String addVictim(String victimName,int victimAge,String victimGender)throws VictimException;
	public List<Victim> showVictimDetails()throws VictimException;
	
}
