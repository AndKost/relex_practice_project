package jsf_module;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Citizen;
import org.DAL.model.Person;


@SessionScoped
@Named(value = "viewDate")
public class viewDateController implements Serializable{
	
	@EJB
	private UserService userService;
	
	private Admin admin = new Admin();
	private Citizen citizen = new Citizen();
	private boolean changeDate = false;
	
	@PostConstruct
	public void Init()
	{
		String login = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if (login == null)
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка загрузки данных", 
							"Попробуйте зайти позже"));
		else
		{
			Person person = userService.getUserOfLogin(login);
			if (person == null)
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка загрузки данных", 
								"Попробуйте зайти позже"));
			else
			{
				if (person instanceof Admin)
				{
					admin = (Admin) person;
					return;
				}
				
				if (person instanceof Citizen)
				{
					citizen = (Citizen) person;
					return;
				}
			}
		}
	}
	
	public void edit()
	{
		changeDate = true;
	}
	
	public void saveCitizen()
	{
		changeDate = false;
		int resultCode;
		resultCode = userService.changeInfoCitizen(citizen.getId(), citizen.getFirstName(), 
								citizen.getLastName(), citizen.getEmail());
		if (resultCode == 0 || resultCode == 1)
		{
			if (resultCode == 1)
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Электронная почта не изменена", 
								"Электронная почта уже занята"));
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, null,  "Данные изменены"));
			admin = (Admin) userService.getUserOfLogin(admin.getLogin());
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка сохранения изменений", 
							"Попробуйте повторить операцию"));
		}
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public boolean isChangeDate() {
		return changeDate;
	}

	public void setChangeDate(boolean changeDate) {
		this.changeDate = changeDate;
	}
	
}
