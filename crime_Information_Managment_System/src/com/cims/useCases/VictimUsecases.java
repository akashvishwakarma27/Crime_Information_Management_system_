package com.cims.useCases;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.VictimDao;
import com.cims.dao.VictimDaoImpl;
import com.cims.exceptions.VictimException;
import com.cims.models.Victim;

public class VictimUsecases {
	
	VictimDao dao=new VictimDaoImpl();
	
	public void addVictim() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter victim name");
		String victimName=sc.next();
		
		System.out.println("Enter victim age");
		int victimAge=sc.nextInt();
		
		System.out.println("Enter victim gender (M/F)");
		String victimGender=sc.next();
		
		try {
			String msg=dao.addVictim(victimName, victimAge, victimGender);
			System.out.println(msg);
			showVictimDetails();
			
		} catch (VictimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sc.close();
	}

	public void showVictimDetails() {
		
		try {
			List<Victim> list=dao.showVictimDetails();
			
			String leftAlignFormat = "| %-4d | %-15s | %-4d | %-8s |%n";
			System.out.format("+------+-----------------+------+----------+%n");
			System.out.format("| ID   | VictimName      | Age  | Gender   |%n");
			System.out.format("+------+-----------------+------+----------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getVictimID(),
						list.get(i).getVictimName(),list.get(i).getVictimAge(),
						list.get(i).getVictimGender());
				
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+-----------------+------+----------+%n");
				
			
		} catch (VictimException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
