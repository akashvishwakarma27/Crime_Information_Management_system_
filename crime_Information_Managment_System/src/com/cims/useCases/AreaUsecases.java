package com.cims.useCases;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.AreaDao;
import com.cims.dao.AreaDaoImpl;
import com.cims.exceptions.AreaException;
import com.cims.models.Area;

public class AreaUsecases {
	
	AreaDao dao=new AreaDaoImpl();
	
	public void addArea() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter area name");
		String areaName=sc.next();
		
		try {
			String msg=dao.addArea(areaName);
			System.out.println(msg);
			showAreaDetails();
			
		} catch (AreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sc.close();
	}
	
	public void showAreaDetails() {
		
		try {
			List<Area> list=dao.showAreaDetails();
			
			String leftAlignFormat = "| %-4d | %-15s |%n";
			System.out.format("+------+-----------------+%n");
			System.out.format("| ID   |   AreaName      |%n");
			System.out.format("+------+-----------------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getAreaID(),list.get(i).getAreaName());
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+-----------------+%n");
				
			
		} catch (AreaException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
