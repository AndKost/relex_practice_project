package jsf_module;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.DAL.*;
import org.DAL.model.*;

@ManagedBean(name = "helloWorld2", eager = true)
public class HelloController {
	
	@EJB
	private UserService userService;
	
	
	
	public String getNameAdmin()
	{
		Person person = userService.getUserOfLogin("admin1");
		if (person == null)
			return "Null";
		Admin admin = (Admin) person;
		return admin.getFirstName();		
	}
	
	public HelloController() {
	      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World2222!";
   }
}
