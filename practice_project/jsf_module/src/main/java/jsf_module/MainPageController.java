package jsf_module;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "mainPage")
public class MainPageController {
	
	public String doActionCitizen()
	{
			return "VIEWDATACITIZEN";
	}
	
	public String doActionAdmin()
	{
			return "VIEWDATAADMIN";
	}
	
	public String toHome()
	{
		return "HOME";
	}
	
	public String toLogin()
	{
		return "LOGIN";
	}

}
