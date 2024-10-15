package app.controller;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.AdminService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Controller
public class AdminController implements ControllerInterfaces{
        @Autowired
        private GuestController GuestController;
        @Autowired
        private PartnerController PartnerController;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private PartnerValidator partnerValidator;
	@Autowired
	private ClubService service;
	//@Autowired
	private InvoiceDto invoiceDto;
	private static final String MENU = "ingrese la opcion que desea \n 1.para crear socio \n 2. para ver historial de facturas de el socio \n 3. para ver historial de facturas de invitado \n 4. para la promocion de facturas \n 5. para cerrar sesion \n";

	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}

	}
	
	private boolean menu() {
		try {
			System.out.println("bienvenido " + ClubService.user.getUserName());
			System.out.print(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		
	}
	
	private boolean options(String option) throws Exception{
		switch (option) {
		case "1": {
			this.createPartner();
			return true;
		}
		case "2": {
			this.showAllInvoicesPartner(invoiceDto, null);;
			//System.out.println("");
			return true;
		}
                
              case "3": {
			this.showAllInvoicesGuest(invoiceDto, null);;
			//System.out.println("");
			return true;
                }
		case "4": {
			this.vipPromotion();
			//System.out.println("");
			return true;
		}
		
		case "5":
			System.out.println("se ha cerrado sesion");
			return false;
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
	
	
	 private void createPartner() throws Exception{
	        System.out.println("ingrese el nombre del socio");
	        String name = Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("ingrese la cedula del socio");
	        long document = personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("ingrese el numero del socio");
		long cellPhone = personValidator.validCellphone(Utils.getReader().nextLine());
		System.out.println("ingrese el nombre de usuario del socio");
		String userName = Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("ingrese la contraseña del socio");
		String password = Utils.getReader().nextLine();
		userValidator.validPassword(password);
	        
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setDocument(document);
		personDto.setCellphone(cellPhone);
		UserDto userDto = new UserDto();
		userDto.setPersonId(personDto);
		userDto.setUserName(userName);
		userDto.setPassword(password);
		userDto.setRole("partner");          
	        PartnerDto partnerDto = new PartnerDto();
	        partnerDto.setUserTol(userDto);
	        partnerDto.setType(true);
	        partnerDto.setAmount(50000);
	        partnerDto.setCreationDate(new Date(System.currentTimeMillis()));
	        this.service.createPartner(partnerDto);
		System.out.println("se ha creado el usuario exitosamente");
	    }  
	
	
	 public void showAllInvoicesPartner(InvoiceDto invoiceDto, InvoiceDetailDto invoiceDetailDto) {
		    System.out.println("Mostrando factura del socio");
		    
		 
		    PartnerController.invoiceHistory(invoiceDto, invoiceDetailDto);
		}

        
        public void showAllInvoicesGuest(InvoiceDto invoiceDto, InvoiceDetailDto invoiceDetailDto){
        System.out.println("mostrando factura del invitado");
        GuestController.invoiceHistory(invoiceDto, invoiceDetailDto);
        }
	
	
        private void vipPromotion() throws Exception{
	        System.out.println("Ascender socio regular a VIP");    
	        PartnerDto partnerDto = new PartnerDto();
	        partnerDto.setType(true);
	    }



}
