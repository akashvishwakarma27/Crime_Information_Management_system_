package com.cims.models;

public class Area {
	
	private int areaID;
	private String areaName;
	
	public Area() {
		// TODO Auto-generated constructor stub
	}

	public Area(int areaID, String areaName) {
		super();
		this.areaID = areaID;
		this.areaName = areaName;
	}

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Area [areaID=" + areaID + ", areaName=" + areaName + "]";
	}
	
}
