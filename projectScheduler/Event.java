package projectScheduler;

import java.time.LocalDate;
import java.util.ArrayList;


public class Event {

	String name;
	String projectname;
	ArrayList<Member> members = new ArrayList<Member>();
	LocalDate startDate;
	LocalDate endDate;
	String description;
	
	public Event(String Iname, String IstartDate, String IendDate, String Idescription, String Iprojectname) {
		this.name = Iname;
		setStartDate(IstartDate);
		setEndDate(IendDate);
		this.description = Idescription;
		this.projectname = Iprojectname;
	}
	
	
	public String getName() 
    { 
        return name; 
    } 
	public ArrayList<Member> getMembers() 
    { 
        return members; 
    } 
	public LocalDate getStartDate() 
    { 
        return startDate; 
    } 
	public LocalDate getEndDate() 
    { 
        return endDate; 
    } 
	
	public String getDescription() 
    { 
        return description; 
    } 
	public String getProjectname() 
    { 
        return projectname; 
    } 
	
	
	public void setName(String Iname) 
    { 
        this.name = Iname; 
    } 
	
	
	
	public void setStartDate(String IstartDate) 
    { 
		this.startDate = LocalDate.parse(IstartDate);
    } 
	
	public void setEndDate(String IEndDate) 
    { 
		this.endDate = LocalDate.parse(IEndDate);
    } 
	//String date = "2016-08-16";

    //default, ISO_LOCAL_DATE
    //LocalDate localDate = LocalDate.parse(date);

    //System.out.println(localDate);
	
	public void setDescription(String Idescription) 
    { 
        this.name = Idescription; 
    }
	
	
	public void addMember(Member Imember) 
    { 
        this.members.add(Imember); 
    }
	
	public String getMemberNames() 
    { 
        String complete = "";
		for(Member m : members) {
        	if(complete == "") {
        		complete = m.getName();
        	}
        	else {
        		complete = complete+", "+m.getName();
        	}
        }
		
		return complete; 
    } 
	
}
