package com.cims.useCases;

import java.util.*;

import com.cims.dao.PoliceStationDao;
import com.cims.dao.PoliceStationDaoImpl;
import com.cims.exceptions.PoliceStationException;
import com.cims.models.PoliceStation;

public class PoliceStationUsecase {

	PoliceStationDao psDao=new PoliceStationDaoImpl();
	
	public void addPoliceStation() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Police Station name");
		String psName=sc.next();
		
		PoliceStation ps=new PoliceStation();
		ps.setPsName(psName);
		
		try {
			String msg=psDao.addPoliceStation(psName);
			System.out.println(msg);
			showPoliceStationDetails();
			
		} catch (PoliceStationException e) {
			System.out.println(e.getMessage());
		}
//		sc.close();
		
	}
	
	public void showPoliceStationDetails() {
		
		try {
			List<PoliceStation> list=psDao.showPoliceStationDetails();
			String leftAlignFormat = "| %-4d | %-15s |%n";
			System.out.format("+------+-----------------+%n");
			System.out.format("| ID   |   PSName        |%n");
			System.out.format("+------+-----------------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getPsID(),list.get(i).getPsName() );
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+-----------------+%n");

			
		} catch (PoliceStationException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
