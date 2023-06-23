package com.cims.main;

import static java.lang.System.exit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.cims.useCases.AreaUsecases;
import com.cims.useCases.CrimeUsecases;
import com.cims.useCases.CriminalUsecases;
import com.cims.useCases.LoginUsecase;
import com.cims.useCases.PoliceStationUsecase;
import com.cims.useCases.VictimUsecases;
import java.util.Calendar;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	
    public static void printMenu(String[] options){
    	
        for (String option : options){
        	System.out.println(ANSI_YELLOW + option + ANSI_RESET);
        }
        
        System.out.print(ANSI_CYAN+"Choose your option: "+ANSI_RESET);
    }

	public static void main(String[] args) {
		
        String[] options = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
                "\u2502    Enter 1  to add a police station                            \u2502",
                "\u2502    Enter 2  to show police stations                            \u2502",
                "\u2502    Enter 3  to add a crime area                                \u2502",
                "\u2502    Enter 4  to show crime areas                                \u2502",
                "\u2502    Enter 5  to add a victim                                    \u2502",
                "\u2502    Enter 6  to show victims                                    \u2502",
                "\u2502    Enter 7  to add a criminal                                  \u2502",
                "\u2502    Enter 8  to show criminals                                  \u2502",
                "\u2502    Enter 9  to report a crime                                  \u2502",
                "\u2502    Enter 10 to show crimes                                     \u2502",
                "\u2502    Enter 11 to search criminal by area                         \u2502",
                "\u2502    Enter 12 to search criminal by police station               \u2502",
                "\u2502    Enter 13 to search crime by area                            \u2502",
                "\u2502    Enter 14 to search crime by police station                  \u2502",
                "\u2502    Enter 15 to check crime status                              \u2502",
                "\u2502    Enter 16 to update crime status                             \u2502",
                "\u2502    Enter 17 to get report of crime status report               \u2502",
                "\u2502    Enter 18 to get count of crime reported in current month    \u2502",
                "\u2502    Enter 19 to exit                                            \u2502",
                "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518"
        };
       
        Calendar cobj = Calendar.getInstance(); 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy");
       
        Scanner scanner = new Scanner(System.in);
       
        int option = 1;
        
        String[] data = { "              \u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
                          "                CRIME INFORMATION MANAGEMENT SYSTEM ",
                          "              \u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518" };
        
        System.out.println(ANSI_YELLOW + "Welcome to Crime Information Management System" + ANSI_RESET);
        
        System.out.println(ANSI_CYAN + "To login to the portal, please authenticate yourself.." + ANSI_RESET);
		
        LoginUsecase login=new LoginUsecase();
		login.validateLogin();
        
		while (option!=19){
            
			for (String s : data) {
                System.out.println(ANSI_RED + s + ANSI_RESET);
            }
			System.out.println("                             सत्यमेव जयते");
			System.out.println("DATE: "+ dfor.format(cobj.getTime())+ "                                       PLACE: PATNA");
            System.out.println("👮   : " + login.getUsername().toUpperCase());
            System.out.println(" ");
            System.out.println(ANSI_CYAN + "Officer " + login.getUsername().substring(0, 1).toUpperCase() + login.getUsername().substring(1)+ ", please use the menu below "
					+ "to select a task.." + ANSI_RESET);
            printMenu(options);
            
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        PoliceStationUsecase ps=new PoliceStationUsecase();
                        ps.addPoliceStation();
                        break;
                    case 2:
                    	PoliceStationUsecase ps1=new PoliceStationUsecase();
                        ps1.showPoliceStationDetails();
                        break;
                    case 3:
                    	AreaUsecases a=new AreaUsecases();
                		a.addArea();
                        break;
                    case 4:
                    	AreaUsecases a2=new AreaUsecases();
                		a2.showAreaDetails();
                        break;
                    case 5:
                		VictimUsecases v=new VictimUsecases();
                		v.addVictim();
                		break;
                    case 6:
                		VictimUsecases v2=new VictimUsecases();
                		v2.showVictimDetails();
                		break;
                    case 7:
                    	CriminalUsecases c = new CriminalUsecases();
                		c.addCriminal(); 
                		break;
                    case 8:
                    	CriminalUsecases c1 = new CriminalUsecases();
                		c1.showCriminalDetails(); 
                		break;
                    case 9:
                    	CrimeUsecases crime=new CrimeUsecases();
                		crime.addCrime();
                		break;
                    case 10:
                    	CrimeUsecases crime1=new CrimeUsecases();
                		crime1.showCrimeDetails();
                		break;
                    case 11:
                    	CriminalUsecases c2 = new CriminalUsecases();
                		c2.SearchCriminalByArea();
                		break;
                    case 12:
                    	CriminalUsecases c3 = new CriminalUsecases();
                		c3.SearchCriminalByPoliceStation();
                		break;
                    case 13:
                    	CrimeUsecases crime4=new CrimeUsecases();
                		crime4.SearchCrimeByArea(); ;
                		break;
                    case 14:
                    	CrimeUsecases crime5=new CrimeUsecases();
                		crime5.SearchCrimeByPoliceStation();
                		break;
                    case 15:
                    	CrimeUsecases crime6=new CrimeUsecases();
                		crime6.checkStatusByCrimeID();
                		break;
                    case 16:
                    	CrimeUsecases crime7=new CrimeUsecases();
                		crime7.updateCrimeStatusByCrimeID();
                		break;
                    case 17:
                    	CrimeUsecases crime8=new CrimeUsecases();
                		crime8.numberOfSolvedOrUnsolvedCases();
                		break; 
                    case 18:
                    	CrimeUsecases crime9=new CrimeUsecases();
                		crime9.numberOfCrimesRecordedInCurrentMonth();
                		break; 
                    case 19:
                    	System.out.println(ANSI_GREEN + "Thanks for using Crime Information "
                    			+ "Management System Portal." + ANSI_RESET);
                        exit(0);
                    default:
                    	System.out.println(ANSI_RED + "Invalid Option. Please enter again" + ANSI_RESET);       	
                    	
                }
            }
            catch (Exception ex){
//            	ex.printStackTrace();
                System.out.println("Invalid input provided. Please enter any key to continue..");
                scanner.next();
            }
        }
		
        scanner.close();
		
	}

}
