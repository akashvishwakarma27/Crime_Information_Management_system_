package com.cims.models;

public class PoliceStation {

	private int psID;
	private String psName;
	
	public PoliceStation() {
		// TODO Auto-generated constructor stub
	}

	public PoliceStation(int psID, String psName) {
		super();
		this.psID = psID;
		this.psName = psName;
	}

	public int getPsID() {
		return psID;
	}

	public void setPsID(int psID) {
		this.psID = psID;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	@Override
	public String toString() {
		return "PoliceStation [psID=" + psID + ", psName=" + psName + "]";
	}
	
}
