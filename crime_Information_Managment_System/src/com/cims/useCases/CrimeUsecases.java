package com.cims.useCases;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.CrimeDao;
import com.cims.dao.CrimeDaoImpl;
import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;
import com.cims.models.CrimeAreaDTO;
import com.cims.models.CrimePoliceStationDTO;

public class CrimeUsecases {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	
	CrimeDao dao=new CrimeDaoImpl();
	
	public void addCrime() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter crime date like yyyy-mm-dd");
		String crimeDate=sc.next();
		
		System.out.println("Enter crime type");
		String crimeType=sc.next();
		
		System.out.println("Enter crime detail");
		sc.nextLine();
		String crimeDetail=sc.nextLine();
		
		System.out.println("Enter crime status like solved or unsolved");
		String crimeStatus=sc.nextLine();
		
		System.out.println("Enter crime suspects");
		String crimeSuspect=sc.nextLine();
		
		System.out.println("Enter criminal ID");
		int criminalID=sc.nextInt();
		
		System.out.println("Enter area ID");
		int areaID=sc.nextInt();
		
		System.out.println("Enter ps ID");
		int psID=sc.nextInt();
		
		System.out.println("Enter victim ID");
		int victimID=sc.nextInt();
		
		
		
		try {
			String msg=dao.addCrime(crimeDate, crimeType, crimeDetail, crimeStatus,
					crimeSuspect, criminalID, areaID, psID, victimID);
			
			System.out.println(msg);
			showCrimeDetails();
			
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sc.close();
	}

	public void showCrimeDetails() {
		
		try {
			List<Crime> list=dao.showCrimeDetails();
			
			System.out.println(ANSI_RED+"CRIME TABLE"+ANSI_RESET);
			
			String leftAlignFormat = "| %-4d | %-10s | %-15s | %-25s | %-10s | %-20s | %-4d | %-4d | %-4d | %-4d |%n";
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+------+------+------+------+%n");
			System.out.format("| ID   | Date       | Type            | Detail                    | Status     | SuspectName          | CrID | ArID | PsID | VmID |%n");
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+------+------+------+------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getCrimeID(),
						list.get(i).getCrimeDate(),list.get(i).getCrimeType(),
						list.get(i).getCrimeDetails(),list.get(i).getCrimeStatus(),
						list.get(i).getCrimeSuspect(),list.get(i).getCriminalID(),
						list.get(i).getAreaID(),list.get(i).getPsID(),list.get(i).getVictimID());
				
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+------+------+------+------+%n");			
		} catch (CrimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	

	public void SearchCrimeByArea() {
		
		try {
			List<CrimeAreaDTO> list=dao.SearchCrimeByArea();
			
			System.out.println(ANSI_RED+"CRIME DETAILS BY AREA"+ANSI_RESET);
			
			String leftAlignFormat = "| %-4d | %-10s | %-15s | %-25s | %-10s | %-20s | %-15s |%n";
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");
			System.out.format("| ID   | Date       | Type            | Detail                    | Status     | SuspectName          | AreaName        |%n");
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getCrimeID(),
						list.get(i).getCrimeDate(),list.get(i).getCrimeType(),
						list.get(i).getCrimeDetails(),list.get(i).getCrimeStatus(),
						list.get(i).getCrimeSuspect(),list.get(i).getAreaName());
			}		
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");			
		
		} catch (CrimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	

	public void SearchCrimeByPoliceStation() {
		
		try {
			List<CrimePoliceStationDTO> list=dao.SearchCrimeByPoliceStation();
			
			System.out.println(ANSI_RED+"CRIME DETAILS BY POLICE STATION"+ANSI_RESET);
			
			String leftAlignFormat = "| %-4d | %-10s | %-15s | %-25s | %-10s | %-20s | %-15s |%n";
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");
			System.out.format("| ID   | Date       | Type            | Detail                    | Status     | SuspectName          | PSName          |%n");
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getCrimeID(),
						list.get(i).getCrimeDate(),list.get(i).getCrimeType(),
						list.get(i).getCrimeDetails(),list.get(i).getCrimeStatus(),
						list.get(i).getCrimeSuspect(),list.get(i).getPsName());
			}		
			System.out.format("+------+------------+-----------------+---------------------------+------------+----------------------+-----------------+%n");			
		
		} catch (CrimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public void checkStatusByCrimeID() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Crime ID");
		int id = sc.nextInt();

//		CrimeDao dao = new CrimeDaoImpl();

		try {
			String status = dao.checkStatusByCrimeID(id);
			
			System.out.println(ANSI_GREEN+status+ANSI_RESET);

		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		
//		sc.close();
	}
	
	public void updateCrimeStatusByCrimeID() {
		showCrimeDetails();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Crime ID that you want to update");
		int id = sc.nextInt();
		
		System.out.println("Enter status(solved/unsolved) to update");
		String status = sc.next();
		

		try {
			String res=dao.updateCrimeStatusByCrimeID(status, id);
			
			System.out.println(ANSI_BLUE+res+ANSI_RESET);
			showCrimeDetails();
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		
//		sc.close();
		
	}
	
	public void numberOfSolvedOrUnsolvedCases() {
		
		try {
			List<String> list=dao.numberOfSolvedOrUnsolvedCases();
			
			System.out.println(ANSI_RED+"CRIME STATUS REPORT"+ANSI_RESET);
			
			String leftAlignFormat = "| %-15s | %-15s |%n";
			System.out.format("+-----------------+-----------------+%n");
			System.out.format("| CrimeStatus     | Count           |%n");
			System.out.format("+-----------------+-----------------+%n");
			
			for(int i=0;i<list.size();i=i+2) {
				System.out.format(leftAlignFormat,list.get(i),
						list.get(i+1));
//				System.out.println(list.get(i));
			}		
			System.out.format("+-----------------+-----------------+%n");			
		
		} catch (CrimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public void numberOfCrimesRecordedInCurrentMonth() {
		
		try {
			int count=dao.numberOfCrimesRecordedInCurrentMonth();
			
			System.out.println(ANSI_RED+"CRIMES RECORDED IN CURRENT MONTH"+ANSI_RESET);
			
			String leftAlignFormat = "| %-15s |%n";
			System.out.format("+-----------------+%n");
			System.out.format("| CrimeRecorded   |%n");
			System.out.format("+-----------------+%n");
			
			System.out.format(leftAlignFormat,count);
						
			System.out.format("+-----------------+%n");
			
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
}


