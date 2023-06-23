package com.cims.models;

public class CrimePoliceStationDTO {

	private int crimeID;
	private String crimeDate;
	private String crimeType;
	private String crimeDetails;
	private String crimeStatus;
	private String crimeSuspect;
	private String psName;
	
	public CrimePoliceStationDTO() {
		// TODO Auto-generated constructor stub
	}

	public CrimePoliceStationDTO(int crimeID, String crimeDate, String crimeType, String crimeDetails,
			String crimeStatus, String crimeSuspect, String psName) {
		super();
		this.crimeID = crimeID;
		this.crimeDate = crimeDate;
		this.crimeType = crimeType;
		this.crimeDetails = crimeDetails;
		this.crimeStatus = crimeStatus;
		this.crimeSuspect = crimeSuspect;
		this.psName = psName;
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

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	@Override
	public String toString() {
		return "CrimePoliceStationDTO [crimeID=" + crimeID + ", crimeDate=" + crimeDate + ", crimeType=" + crimeType
				+ ", crimeDetails=" + crimeDetails + ", crimeStatus=" + crimeStatus + ", crimeSuspect=" + crimeSuspect
				+ ", psName=" + psName + "]";
	}
	
}
