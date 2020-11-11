package projectScheduler;

//import java.time.LocalDate;
//import java.util.ArrayList;

public class Member {

	String name;
	String email;
	
	public Member(String Iname, String Iemail) {
		setName(Iname);
		setEmail(Iemail);
	}
	
	public String getName() 
    { 
        return name; 
    } 
	public String getEmail() 
    { 
        return email; 
    } 
	
	public void setName(String Iname) 
    { 
        this.name = Iname; 
    } 
	
	public void setEmail(String Iemail) 
    { 
        this.email = Iemail; 
    } 
	
	public String formatMember(int i) 
    { 
        String out = "";
        out = "("+i+")"+" "+this.getName()+": "+this.getEmail();
		return out; 
    } 
	
	
}