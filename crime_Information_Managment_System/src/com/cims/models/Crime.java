package com.cims.models;

public class Crime {
	
	private int crimeID;
	private String crimeDate;
	private String crimeType;
	private String crimeDetails;
	private String crimeStatus;
	private String crimeSuspect;
	private int criminalID;
	private int areaID;
	private int psID;
	private int victimID;
	
	public Crime() {
		// TODO Auto-generated constructor stub
	}

	public Crime(int crimeID, String crimeDate, String crimeType, String crimeDetails, String crimeStatus,
			String crimeSuspect, int criminalID, int areaID, int psID, int victimID) {
		super();
		this.crimeID = crimeID;
		this.crimeDate = crimeDate;
		this.crimeType = crimeType;
		this.crimeDetails = crimeDetails;
		this.crimeStatus = crimeStatus;
		this.crimeSuspect = crimeSuspect;
		this.criminalID = criminalID;
		this.areaID = areaID;
		this.psID = psID;
		this.victimID = victimID;
	}

	public int getCrimeID() {
		return crimeID;
	}

	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}

	public String getCrimeDate() {
		return crimeDate;
	}

	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getCrimeDetails() {
		return crimeDetails;
	}

	public void setCrimeDetails(String crimeDetails) {
		this.crimeDetails = crimeDetails;
	}

	public String getCrimeStatus() {
		return crimeStatus;
	}

	public void setCrimeStatus(String crimeStatus) {
		this.crimeStatus = crimeStatus;
	}

	public String getCrimeSuspect() {
		return crimeSuspect;
	}

	public void setCrimeSuspect(String crimeSuspect) {
		this.crimeSuspect = crimeSuspect;
	}

	public int getCriminalID() {
		return criminalID;
	}

	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public int getPsID() {
		return psID;
	}

	public void setPsID(int psID) {
		this.psID = psID;
	}

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
	}

	@Override
	public String toString() {
		return "Crime [crimeID=" + crimeID + ", crimeDate=" + crimeDate + ", crimeType=" + crimeType + ", crimeDetails="
				+ crimeDetails + ", crimeStatus=" + crimeStatus + ", crimeSuspect=" + crimeSuspect + ", criminalID="
				+ criminalID + ", areaID=" + areaID + ", psID=" + psID + ", victimID=" + victimID + "]";
	}
	
	
}
 
