package org.use_module;

import java.util.Date;



import org.DAL.*;
import org.DAL.model.Admin;
import org.DAL.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        UserService userDAO = new UserService();
        System.out.println( "Insert start!" );
        Admin admin = new Admin();
        admin.setLogin("admin3");
        admin.setEmail("admin111@mail.ru");
        admin.setFirstName("Ivan22");
        admin.setLastName("Ivanov22");
        admin.setPassword("1234577");
        admin.setPhone("89103494786");
        admin.setRegistrationDate(new Date());
        //userDAO.insertUser(admin);
        System.out.println( "Insert finish!" );
        System.out.println( "Select start!" );
        Person user = userDAO.getUserOfLogin("admin2");
        if (user instanceof Admin)
        	printAdmin((Admin)user);
        else
        	System.out.println("Error");
        //userDAO.changePassword(4, "54321");
        System.out.println( "Select finish!" );
    }
    
    private static void printAdmin(Admin admin)
    {
    	System.out.println(admin.getId());
    	System.out.println(admin.getLogin());
    	System.out.println(admin.getFirstName());
    	System.out.println(admin.getLastName());
    	System.out.println(admin.getEmail());
    }
}
