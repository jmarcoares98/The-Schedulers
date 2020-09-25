package projectScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
public class Project {
	String name;
	
	ArrayList<Member> members = new ArrayList<Member>();
	ArrayList<Event> Events = new ArrayList<Event>();
	
	String description;
	
	public Project(String Iname, String Idescription) {
		this.name = Iname;
		this.description = Idescription;
	}
	
	
	public String getName() 
    { 
        return name; 
    }
	
	public ArrayList<Member> getMembers() 
    { 
        return members; 
    } 
	
	
	public String getDescription() 
    { 
        return description; 
    } 
	
	public void setName(String Iname) 
    { 
        this.name = Iname; 
    } 
	
	public void setDescription(String Idescription) 
    { 
        this.name = Idescription; 
    }
	public void addMember(Member Imember) 
    { 
        this.members.add(Imember); 
    }
	
}
