package com.cims.models;

public class Victim {
	private int victimID;
	private String victimName;
	private int victimAge;
	private String victimGender;
	
	public Victim() {
		// TODO Auto-generated constructor stub
	}

	public Victim(int victimID, String victimName, int victimAge, String victimGender) {
		super();
		this.victimID = victimID;
		this.victimName = victimName;
		this.victimAge = victimAge;
		this.victimGender = victimGender;
	}

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public int getVictimAge() {
		return victimAge;
	}

	public void setVictimAge(int victimAge) {
		this.victimAge = victimAge;
	}

	public String getVictimGender() {
		return victimGender;
	}

	public void setVictimGender(String victimGender) {
		this.victimGender = victimGender;
	}

	@Override
	public String toString() {
		return "Victim [victimID=" + victimID + ", victimName=" + victimName + ", victimAge=" + victimAge
				+ ", victimGender=" + victimGender + "]";
	}
	
	
}
