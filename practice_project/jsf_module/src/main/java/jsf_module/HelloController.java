package jsf_module;

import java.util.Date;

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
		Admin admin = new Admin();
		admin.setLogin("admin2");
		admin.setPassword("12345");
        admin.setEmail("admin111@mail.ru");
        admin.setFirstName("Ivan5");
        admin.setLastName("Ivanov22");
        admin.setPhone("89103494786");
        admin.setRegistrationDate(new Date());
        userService.registrationAdmin(admin.getLogin(), admin.getPassword(), 
        		admin.getEmail(), admin.getFirstName(), admin.getLastName(), admin.getPhone());
		Person person = userService.getUserOfLogin("admin2");
		if (person == null)
			return "Null";
		Admin admin2 = (Admin) person;
		return admin2.getFirstName();		
	}
	
	public HelloController() {
	      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World2222!";
   }
}
