package jsf_module;


import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.DAL.UserService;
import org.DAL.model.Admin;
import org.DAL.model.Citizen;
import org.DAL.model.Person;


@Named(value = "viewData")
@ConversationScoped
public class viewDataController implements Serializable{
	
	@EJB
	private UserService userService;
	private Admin admin = new Admin();
	private Citizen citizen = new Citizen();
	private boolean changeData = false;
	private String time;
	private boolean isTransient = true;
	
	@Inject
	private UserLogController userLogController;
	
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void Init()
	{
		Date tmp = new Date();
		time = tmp.toString();
		Person person = userLogController.getAuthorizedUser();
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
	
	public void edit()
	{
		changeData = true;
	}
	
	public void saveCitizen()
	{
		changeData = false;
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
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Данные изменены",  
							"Изменения сохранены"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка сохранения изменений", 
							"Попробуйте повторить операцию"));
		}
		citizen = (Citizen) userService.getUserOfLogin(citizen.getLogin());
	}
	
	public void saveAdmin()
	{
		changeData = false;
		int resultCode;
		resultCode = userService.changeInfoAdmin(admin.getId(), admin.getFirstName(), 
					admin.getLastName(), admin.getPhone(), admin.getEmail());
		if (resultCode == 0 || resultCode == 1)
		{
			if (resultCode == 1)
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Электронная почта не изменена", 
								"Электронная почта уже занята"));
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Данные изменены",  
							"Изменения сохранены"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка сохранения изменений", 
							"Попробуйте повторить операцию"));
		}
		admin = (Admin) userService.getUserOfLogin(admin.getLogin());
	}
	
	public String toHome()
	{
		isTransient = conversation.isTransient();
		if (!isTransient)
			conversation.end();
		return "/faces/index?faces-redirect=true";
	}
	
	public String viewDataAdmin()
	{
		isTransient = conversation.isTransient();
		if (isTransient)
			conversation.begin();
		return "VIEWDATAADMIN";
	}
	
	public String viewData()
	{
		isTransient = conversation.isTransient();
		if (isTransient)
			conversation.begin();
		String typeUser = userLogController.getTypeUser();
		if (typeUser.equals("ADMIN"))
			return "VIEWDATAADMIN";
		if (typeUser.equals("CITIZEN"))
			return "VIEWDATACITIZEN";
		isTransient = conversation.isTransient();
		if (!isTransient)
			conversation.end();
		return "";
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

	public boolean isChangeData() {
		return changeData;
	}

	public void setChangeData(boolean changeDate) {
		this.changeData = changeDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
