package com.cims.models;

public class CriminalAreaDTO {
	
	private int criminalID;
	private String criminalName;
	private int criminalAge;
	private String criminalGender;
	private String criminalAddress;
	private String criminalIdentificationMark;
	private String areaName;
	
	public CriminalAreaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CriminalAreaDTO(int criminalID, String criminalName, int criminalAge, String criminalGender,
			String criminalAddress, String criminalIdentificationMark, String areaName) {
		super();
		this.criminalID = criminalID;
		this.criminalName = criminalName;
		this.criminalAge = criminalAge;
		this.criminalGender = criminalGender;
		this.criminalAddress = criminalAddress;
		this.criminalIdentificationMark = criminalIdentificationMark;
		this.areaName = areaName;
	}

	public int getCriminalID() {
		return criminalID;
	}

	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getCriminalAge() {
		return criminalAge;
	}

	public void setCriminalAge(int criminalAge) {
		this.criminalAge = criminalAge;
	}

	public String getCriminalGender() {
		return criminalGender;
	}

	public void setCriminalGender(String criminalGender) {
		this.criminalGender = criminalGender;
	}

	public String getCriminalAddress() {
		return criminalAddress;
	}

	public void setCriminalAddress(String criminalAddress) {
		this.criminalAddress = criminalAddress;
	}

	public String getCriminalIdentificationMark() {
		return criminalIdentificationMark;
	}

	public void setCriminalIdentificationMark(String criminalIdentificationMark) {
		this.criminalIdentificationMark = criminalIdentificationMark;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "CriminalAreaDTO [criminalID=" + criminalID + ", criminalName=" + criminalName + ", criminalAge="
				+ criminalAge + ", criminalGender=" + criminalGender + ", criminalAddress=" + criminalAddress
				+ ", criminalIdentificationMark=" + criminalIdentificationMark + ", areaName=" + areaName + "]";
	}
	
}
