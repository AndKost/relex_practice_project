package jsf_module;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import org.DAL.*;
import org.DAL.model.*;

@SessionScoped
@Named(value = "user") 
public class UserController implements Serializable {
	
	@EJB
	private UserService userService;
	
	@EJB
	private AdminCodeService adminCodeService;
	
	@EJB
	private UserRolesService userRolesService;
	
	private String repeatPassword = "";
	private Admin admin = new Admin();
	private Citizen citizen = new Citizen();
	private String adminCode = "";
	private String time;
	
	@PostConstruct
	public void Init() 
	{
		Date tmp = new Date();
		time = tmp.toString();
	}
	
	public void checkLogin(FacesContext facesContext, UIComponent component, Object value)
		throws ValidatorException
	{
		String login = (String) value;
		if (login.equals(""))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Введите логин"));
		String regex = "^[a-zA-Z0-9_-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(login);
		if (!matcher.matches())
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Логин содержит недопустимые символы"));
		if (login.length() < 3 || login.length() > 25)
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Логин должен сожержать от 3 до 15 символов"));
		Person person = userService.getUserOfLogin(login);
		if (person != null)
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Логин уже занят"));
	}
	
	public void checkPassword(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException
	{
		String password = (String) value;
		if (password.equals(""))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Введите пароль"));
		if (password.length() < 6 || password.length() > 25)
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Пароль должен сожержать от 6 до 15 символов"));
	}
	
	public void checkRepeatPasswordAdmin(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException
	{
		String password = (String) value;
		if (password.equals(""))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Введите пароль")); 
		if (!password.equals(admin.getPassword()))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Пароли не совпадают"));
	}
	
	public void checkRepeatPasswordCitizen(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException
	{
		String password = (String) value;
		if (password.equals(""))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Введите пароль"));
		if (!password.equals(citizen.getPassword()))
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Пароли не совпадают"));
	}
	
	public void checkEmail(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException
	{
		String email = (String) value;
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches())
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Электронная почта имеет не верный формат"));
	}
	
	public void checkAdminCode(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException
	{
		AdminCode tmp = adminCodeService.getAdminCodeOfCode(adminCode);
		if (tmp == null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", 
							"Введен неверный регистрационный ключ"));
	}
	
	public String getRepeatPassword() {
		return repeatPassword;
	}
	
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String registrationAdmin()
	{
		AdminCode tmp = adminCodeService.getAdminCodeOfCode(adminCode);
		if (tmp == null)
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка регистрации", 
							"Повториту попытку"));
			return "";
		}
		admin.setRegistrationDate(new Date());
		try
		{
			userService.registrationPerson(admin);
			adminCodeService.deleteCode(tmp.getId());
		} catch (Exception ex)
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка регистрации", 
							"Повториту попытку"));
			return "";
		}
		UserRoles userRole = new UserRoles();
		userRole.setLogin(admin.getLogin());
		userRole.setRole("ADMIN");
		userRolesService.addUser(userRole);
		admin = new Admin();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Регистрация прошла успешно", 
						null));
		return "/faces/index?faces-redirect=true";
	}

	public String registrationCitizen()
	{
		citizen.setRegistrationDate(new Date());
		try
		{
			userService.registrationPerson(citizen);
		} catch (Exception ex)
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка регистрации", 
							"Повториту попытку"));
			return "";
		}
		UserRoles userRole = new UserRoles();
		userRole.setLogin(citizen.getLogin());
		userRole.setRole("USER");
		userRolesService.addUser(userRole);
		citizen = new Citizen();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Регистрация прошла успешно", 
						null));
		return "/faces/index?faces-redirect=true";
	}
	
	public String cancel()
	{
		return "/faces/index?faces-redirect=true";
	}
	
	public String newAdmin()
	{
		return "/faces/faces/resources/visitor/registrationAdmin.xhtml?faces-redirect=true";
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

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
	
	
	
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
