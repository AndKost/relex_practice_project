package jsf_module;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.inject.Named;

import org.DAL.*;
import org.DAL.model.*;

@SessionScoped
@Named(value = "user") 
public class UserController {
	
	@EJB
	private UserService userService;
	@EJB
	private AdminCodeService adminCodeService;
	private String resultMessage = "";
	private Admin admin = new Admin();
	private Citizen citizen = new Citizen();
	private String adminCode = "";
	
	public String getResultMessage() {
		return resultMessage;
	}
	
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public void resitrationAdmin()
	{
		resultMessage = "";
		checkPersonInfo(admin);
		if (!resultMessage.equals(""))
			return;
		if (admin.getEmail().equals("") || admin.getFirstName().equals("") ||
				admin.getLastName().equals("") || admin.getPhone().equals(""))
		{
			resultMessage = "Заполните все поля!";
			return;
		}
		int resultCode = userService.checkNewPerson(admin);
		if (resultCode == 1)
		{
			resultMessage = "Логин занят, введите новый!";
			return;
		}
		if (resultCode == 2)
		{
			resultMessage = "Пользователь с таким email уже зарегистрирован!";
			return;
		}
		AdminCode tmp = adminCodeService.getAdminCodeOfCode(adminCode);
		if (tmp == null)
		{
			resultMessage = "Введен неверный регистрационный код!";
			return;
		}
		admin.setRegistrationDate(new Date());
		cipherPassword(admin);
		userService.registrationPerson(admin);
		adminCodeService.deleteCode(tmp.getId());
		resultMessage = "Регистрация прошла успешно!";
	}
	
	private void cipherPassword(Person newPerson)
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(newPerson.getPassword().getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	         newPerson.setPassword(sb.toString());
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public void resitrationCitizen()
	{
		resultMessage = "";
		checkPersonInfo(citizen);
		if (!resultMessage.equals(""))
			return;
		if (citizen.getEmail().equals("") || citizen.getFirstName().equals("") ||
			citizen.getLastName().equals(""))
		{
			resultMessage = "Заполните все поля!";
			return;
		}
		int resultCode = userService.checkNewPerson(citizen);
		if (resultCode == 1)
		{
			resultMessage = "Логин занят, введите новый!";
			return;
		}
		if (resultCode == 2)
		{
			resultMessage = "Пользователь с таким email уже зарегистрирован!";
			return;
		}
		citizen.setRegistrationDate(new Date());
		userService.registrationPerson(citizen);
		resultMessage = "Регистрация прошла успешно!";
	}
	
	private void checkPersonInfo(Person person)
	{
		if (person.getLogin().equals("") || person.getLogin().length() > 15)
		{
			resultMessage = "Длина логина должна быть в диапозоне от 1 до 15 символов!";
			return;
		}
		if (person.getPassword().length() < 6)
		{
			resultMessage = "Длина пароля должна быть не менее 6 символов!";
			return;
		}
		if (person.getPassword().length() > 20)
		{
			resultMessage = "Длина пароля не должна превышать 20 символов!";
			return;
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
	
}
