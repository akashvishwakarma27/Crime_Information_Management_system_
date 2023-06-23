package com.cims.dao;

import java.util.List;

import com.cims.exceptions.AreaException;
import com.cims.models.Area;

public interface AreaDao {
	
	public String addArea(String areaName)throws AreaException;
	public List<Area> showAreaDetails()throws AreaException;
}
