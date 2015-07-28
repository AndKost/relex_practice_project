package jsf_module;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

@RequestScoped
@Named(value="log")
public class LogoutController {
	
	public String logout()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		if (httpSession != null)
			httpSession.invalidate();
		return "#{facesContext.externalContext.requestContextPath}/";
	}

}
