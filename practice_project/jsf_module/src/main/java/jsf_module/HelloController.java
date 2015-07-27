package jsf_module;

import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Person;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@SessionScoped
@Named(value = "helloWorld2")
public class HelloController implements Serializable {

    @EJB
    private UserService userService;

    public String getNameAdmin() {
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

    public String doAction() {
        return "Index/Add";
    }

    public HelloController() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World2222!";
    }
}
