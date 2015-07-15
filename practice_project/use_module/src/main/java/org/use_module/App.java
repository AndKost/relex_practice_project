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
        System.out.println( "Insert start!" );
        Admin admin = new Admin();
        admin.setLogin("admin2");
        admin.setEmail("admin2@mail.ru");
        admin.setFirstName("Ivan");
        admin.setLastName("Ivanov");
        admin.setPassword("12345");
        admin.setPhone("89103494786");
        admin.setRegistrationDate(new Date());
        //UserDAO.insertUser(admin);
        System.out.println( "Insert finish!" );
        System.out.println( "Select start!" );
        UserDAO userDAO = new UserDAO();
        Person user = userDAO.getUserOfLogin("admin2");
        if (user instanceof Admin)
        	printAdmin((Admin)user);
        else
        	System.out.println("Error");
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
