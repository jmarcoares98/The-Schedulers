package projectScheduler;

import java.util.Scanner;  // Import the Scanner class
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
public class Main {

	public static void printProjects(ArrayList<Project> PL) {//Prints all projects with numbers in front
		int i = 1;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~Your Projects~~~~~~~~~~~~~~~~~~~~~");
		for (Project p : PL){
			System.out.println("("+i+")"+" "+p.getName()+": "+p.getDescription());
			i++;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public static void printProjMem(Project P) {//Prints the members of a project with numbers in front
		int i = 1;
		System.out.println("~~~~~~~~~~~~~~~~~~~~Project Members~~~~~~~~~~~~~~~~~~~~");
		for (Member m : P.members){
			System.out.println("("+i+")"+" "+m.getName()+": "+m.getEmail());
			i++;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public static void printEvents(ArrayList<Project> PL) {//Prints Events in order
		LocalDate curDate = LocalDate.now();
		int past = 1;
		ArrayList<Event> orderedEvents = new ArrayList<Event>();
		
		if(PL.isEmpty()) {
			System.out.println("No Projects");
		}
		else {
			for (Project p : PL){//for every project
				for (Event e : p.Events){//for every event in every project
						orderedEvents.add(e);
				}
			}
			if(orderedEvents.isEmpty()) {
				System.out.println("No Events");
			}
			else {
				orderedEvents.sort((d1,d2)->d1.getEndDate().compareTo(d2.getEndDate()));
				for (Event e : orderedEvents){
					if (past==1 && e.getEndDate().compareTo(curDate)<0) {
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~Past Events~~~~~~~~~~~~~~~~~~~~~~");
						past=0;
					}
					System.out.println(e.getEndDate()+" "+e.getProjectname()+": "+e.getName()+"- "+e.getMemberNames());
				}
			}
		}
	}
	public static void printEventsNum(ArrayList<Project> PL) {//Prints Events in order but with numbers in front
		int i = 1;
		ArrayList<Event> orderedEvents = new ArrayList<Event>();
		
		if(PL.isEmpty()) {
			System.out.println("No Projects");
		}
		else {
			for (Project p : PL){//for every project
				for (Event e : p.Events){//for every event in every project
						orderedEvents.add(e);
				}
			}
			if(orderedEvents.isEmpty()) {
				System.out.println("No Events");
			}
			else {
				orderedEvents.sort((d1,d2)->d1.getEndDate().compareTo(d2.getEndDate()));
				for (Event e : orderedEvents){
					System.out.println("("+i+")"+e.getEndDate()+" "+e.getProjectname()+": "+e.getName()+"- "+e.getMemberNames());
					i++;
				}
			}
		}
	}
	public static ArrayList<Event> orderEvents(ArrayList<Project> PL) {//Orders Events by end date
		int i = 1;
		ArrayList<Event> orderedEvents = new ArrayList<Event>();
		
		if(PL.isEmpty()) {
			System.out.println("No Projects");
		}
		else {
			for (Project p : PL){//for every project
				for (Event e : p.Events){//for every event in every project
						orderedEvents.add(e);
				}
			}
			if(orderedEvents.isEmpty()) {
				System.out.println("No Events");
			}
			else {
				orderedEvents.sort((d1,d2)->d1.getEndDate().compareTo(d2.getEndDate()));
			
			}
		}
		return orderedEvents;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int go = 1;
		int go2 = 1;
		ArrayList<Project> projectL = new ArrayList<Project>();
		ArrayList<Event> eventlist= new ArrayList<Event>();
		int i;
		int j;
		String inp1;
		String inp2;
		String inp3;
		String inp4;
		String inp5;
		String inp6;
		String[] strL;
		String[] strL2;
		LocalDate date1;
		LocalDate date2;
		LocalDate curDate = LocalDate.now();
		
		
		while (go == 1){
			System.out.println("-------------------Project Scheduler-------------------");
			System.out.println("*********************Your Schedule*********************");
			printEvents(projectL);
			System.out.println("*******************************************************");
			System.out.println("Please make a selection:");
			System.out.println("|1|Add Project");
			System.out.println("|2|Remove Project");
			System.out.println("|3|View Event");
			System.out.println("|4|Add Event");
			System.out.println("|5|Remove Event");
			System.out.println("|6|Save Schedule");
			System.out.println("|7|Load Schedule");
			System.out.println("|0|Close scheduler");
			System.out.println("-------------------------------------------------------");
			System.out.println("Please enter input:");
			String input = scan.nextLine();
			switch (input) {
			case "1"://Add Project
				System.out.println("What is the name of your Project?:");
				inp1 = scan.nextLine();
				System.out.println("Give a one-line description of your Project:");
				inp2 = scan.nextLine();
				System.out.println("Who will be working on this Project? (nameofmember1-email/nameofmember2-email/nameofmember3-email):");
				inp3 = scan.nextLine();
				strL = inp3.split("/");
				projectL.add(new Project(inp1, inp2));
				for(String s : strL) {
					strL2 = s.split("-");
					projectL.get(projectL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
				}
				
				printProjects(projectL);
				
				break;
			case "2"://remove Project
				printProjects(projectL);
				System.out.println("What is the number of the project to be removed?:");
				inp1 = scan.nextLine();
				i = Integer.parseInt(inp1);
				projectL.remove(i-1);	
				printProjects(projectL);
				break;
			case "3"://View Event
				printEventsNum(projectL);
				eventlist = orderEvents(projectL);
				if (!eventlist.isEmpty()) {
					System.out.println("What event would you like to look at?:");
					inp1 = scan.nextLine();
					i = Integer.parseInt(inp1);
					System.out.println("Project:      "+eventlist.get(i-1).getProjectname());
					System.out.println("Event:        "+eventlist.get(i-1).getName());
					System.out.println("Assigned:     "+eventlist.get(i-1).getMemberNames());
					System.out.println("Start date:   "+eventlist.get(i-1).getStartDate());
					System.out.println("End date:     "+eventlist.get(i-1).getEndDate());
					j = eventlist.get(i-1).getStartDate().compareTo(curDate);
					//if (j >=0) {
					//	System.out.println("Days passed:  "+j);
					//}
					
					
					
				}
				break;
			case "4"://Add Event
				if (projectL.isEmpty()) {
					System.out.println("No projects exist: Please make one first!");
				}
				else {
					printProjects(projectL);
					System.out.println("What project would you like to add the event to?");
					inp1 = scan.nextLine();
					i = Integer.parseInt(inp1);
					System.out.println("What is the name of the event?");
					inp2 = scan.nextLine();
					System.out.println("Give a one-line description of your Event:");
					inp3 = scan.nextLine();
					System.out.println("What is the starting date of the Event? (YYYY-MM-DD):");
					inp4 = scan.nextLine();
					//date1 = LocalDate.parse(inp4);
					System.out.println("What is the ending date of the Event? (YYYY-MM-DD):");
					inp5 = scan.nextLine();
					//date2 = LocalDate.parse(inp5);
					
					printProjMem(projectL.get(i-1));
					System.out.println("Who is working on this event?(membernumber/membernumber):");
					inp6 = scan.nextLine();
					strL = inp6.split("/");
					
					projectL.get(i-1).Events.add(new Event(inp2,inp4,inp5,inp3,projectL.get(i-1).getName()));
					
					for (String m : strL) {
						j = Integer.parseInt(m);
						projectL.get(i-1).Events.get(projectL.get(i-1).Events.size() - 1).addMember(projectL.get(i-1).members.get(j-1));
					}
					
					
					
				}
				
				break;
			case "5"://Remove Event
				printEventsNum(projectL);
				eventlist = orderEvents(projectL);
				if (!eventlist.isEmpty()) {
					System.out.println("What event would you like to remove?:");
					inp1 = scan.nextLine();
					i = Integer.parseInt(inp1);
					eventlist.remove(i-1);
				}
				break;
			case "6"://Save Schedule
				System.out.println("~WIP~");
				break;
			case "7"://Load Schedule
				System.out.println("~WIP~");
				break;
			case "0"://Close Scheduler
				System.out.println("~Goodbye~");
				go = 0;
				break;
			default:	
				System.out.println("~Error: input does not exist~");
				break;
			}//switch
		
		
		}//while loop
		
		
		scan.close();
		
	}

}
