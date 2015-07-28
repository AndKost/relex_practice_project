package jsf_module;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Citizen;
import org.DAL.model.Person;

@RequestScoped
@Named(value="userLog")
public class UserLogController {
	
	@EJB
	private UserService userService;
	
	public String logout()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		if (httpSession != null)
			httpSession.invalidate();
		return "HOME";
	}
	
	public String getLoginAuthorizedUser()
	{
		String login = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		return login;
	}
	
	public Person getAuthorizedUser()
	{
		Person user;
		String login = getLoginAuthorizedUser();
		if (login == null)
			return null;
		user = userService.getUserOfLogin(login);
		return user;
	}
	
	public String getTypeUser()
	{
		Person person = getAuthorizedUser();
		if (person instanceof Admin)
			return "ADMIN";
		if (person instanceof Citizen)
			return "CITIZEN";
		return "VISITOR";
	}

}
