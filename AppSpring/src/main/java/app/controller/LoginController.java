package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.AdminService;
import app.service.interfaces.LoginService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Controller
public class LoginController implements ControllerInterfaces{
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private LoginService service;
	private static final String MENU = "ingrese la opcion que desea \n 1.para iniciar sesion \n 2. para detener la ejecucion \n";
	
	private Map<String,ControllerInterfaces> roles;
	public LoginController(AdminController adminController, PartnerController PartnerController,GuestController guestController) {
		this.roles= new HashMap<String,ControllerInterfaces>();
		roles.put("admin", adminController);
		roles.put("Partner", PartnerController);
		roles.put("Guest", guestController);
	}
	
	@Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}		
	}
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			this.login();
			return true;
		}
		case "2": {
			System.out.println("se detiene el programa");;
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
	
	private void login()throws Exception {
		System.out.println("ingrese el usuario");
		String userName= Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("ingrese la contraseña");
		String password= Utils.getReader().nextLine();
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPassword(password);
		userDto.setUserName(userName);
		
		this.service.login(userDto);
		if(roles.get(userDto.getRole())==null) {
			throw new Exception ("Rol invalido");
		}
		roles.get(userDto.getRole()).session();
		
	}
	
	
	
	

}
