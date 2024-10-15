package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.sql.Date;

import app.controller.validator.DetailValidator;
import app.controller.validator.InvoiceValidator;
import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.GuestValidator;
import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.AdminService;
import app.service.interfaces.GuestService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Controller
public class PartnerController implements ControllerInterfaces{
    private List<InvoiceDto> invoiceList = new ArrayList<>();
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private PartnerValidator partnerValidator;
	@Autowired
	private InvoiceValidator invoiceValidator;
	@Autowired
	private DetailValidator detailValidator;
	@Autowired
	private GuestValidator guestValidator;
	@Autowired
	private ClubService Service;
	
	private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1. para crear invitado. \n 2. para activar invitado \n 3. para desactivar invitado \n 4. para hacer consumo \n 5.para solicitar baja \n 6. para cerrar sesion \n";

	ClubService service = new ClubService();
	@Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = PartnerSession();
		}

	    }
	
	private boolean PartnerSession() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	    }
	
	private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			this.createGuest();
			return true;
		}
		case "2": {
			this.activateGuest();
			return true;
		}
		case "3": {
			this.disableGuest();
			return true;
		}
		case "4": {
			this.createInvoice();
			return true;
		}
		case "5": {
			this.requestUnsubscribe();
			return true;
		}
		case "6": {
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	    }
	

	
	public void invoiceHistory(InvoiceDto invoiceDto, InvoiceDetailDto invoiceDetailDto) {
	    System.out.println("Detalles de la Factura:");
	    System.out.println("----------------------");
	    System.out.println("ID de la Persona: " + invoiceDto.getPersonId().getId());
	    System.out.println("ID del Socio: " + invoiceDto.getPartnerId().getId());
	    System.out.println("Estado: " + invoiceDto.isStatus());
	    System.out.println("Monto: " + invoiceDto.getAmount());
	    System.out.println("Fecha de Creación: " + invoiceDto.getCreationDate());
	    
	    System.out.println("\nDetalles de la Línea de Factura:");
	    System.out.println("-------------------------------");
	    System.out.println("ID de la Factura: " + invoiceDetailDto.getInvoiceId().getId());
	    System.out.println("Ítem: " + invoiceDetailDto.getItem());
	    System.out.println("Descripción: " + invoiceDetailDto.getDescription());
	    System.out.println("Monto de la Línea: " + invoiceDetailDto.getAmount());
	}

	private void createInvoice() throws Exception {
	    System.out.println("Ingrese el ítem de la factura:");
	    int item = invoiceValidator.validItem(Utils.getReader().nextLine());
	    
	    System.out.println("Ingrese la descripción de la factura:");
	    String description = Utils.getReader().nextLine();
	    invoiceValidator.validDescription(description);
	    
	    System.out.println("Ingrese el valor de la factura:");
	    double amount = invoiceValidator.validAmount(Utils.getReader().nextLine());

	    PersonDto personDto = new PersonDto(); 
	    PartnerDto partnerDto = new PartnerDto();

	    InvoiceDto invoiceDto = new InvoiceDto();
	    invoiceDto.setPersonId(personDto);
	    invoiceDto.setPartnerId(partnerDto);
	    invoiceDto.setStatus(false);
	    invoiceDto.setAmount(amount);
	    invoiceDto.setCreationDate(Utils.getDate());

	    InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
	    invoiceDetailDto.setInvoiceId(invoiceDto);
	    invoiceDetailDto.setItem(item);
	    invoiceDetailDto.setDescription(description);
	    invoiceDetailDto.setAmount(amount);
	    
	    this.service.createInvoiceDetail(invoiceDetailDto);
	    invoiceHistory(invoiceDto, invoiceDetailDto); 
	    System.out.println("Se ha creado la factura exitosamente.");
	}

        
       
	
	public void createGuest ()throws Exception  {
		System.out.println("ingrese el nombre del invitado");
		String name = Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("ingrese el documento del invitado");
		String document = Utils.getReader().nextLine();
		personValidator.validDocument(document);
		System.out.println("ingrese el numero celular del invitado");
		String celphone = Utils.getReader().nextLine();
		personValidator.validDocument(celphone);
		System.out.println("ingrese el estado de la invitacion (activa o inactiva)");
		boolean status = Utils.getReader().hasNextBoolean();
		guestValidator.validStatus(status);
		GuestDto guestDto = new GuestDto();
		PersonDto personDto = new PersonDto();
		UserDto userDto = new UserDto();
		personDto.setName(name);
		personDto.setCellphone(0);
		personDto.setDocument(0);
		userDto.setRole("Guest");
		this.service.createbecomepartner(guestDto);
		System.out.println("se ha creado el usuario exitosamente");
		
	}
	
	
	private void incrementAmount() throws Exception{
        System.out.println("Ingrese el monto que desea aumentar");
        double amount = partnerValidator.validAmount(Utils.getReader().nextLine());   
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setAmount(amount);
        this.service.incrementAmount(partnerDto);
    }
	private void disableGuest()throws Exception{
        System.out.println("desactivar invitado");
        System.out.println("numero de cedula del invitado");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
        this.service.disableGuest(document);
        System.out.println("el usuario a sido desactivado");
    }
    
	private void activateGuest()throws Exception{
        System.out.println("activar invitado"); 
        System.out.println("numero de cedula del invitado");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
        this.Service.activateGuest(document);
        System.out.println("usuario a sido activado");
    }
	
	 private void vipPromotion() throws Exception{
	        System.out.println("Ascender socio regular a VIP");    
	        PartnerDto partnerDto = new PartnerDto();
	        partnerDto.setType(true);
	    }
	 private void requestUnsubscribe() throws Exception {

		    System.out.println("Ingrese el número de documento del socio para solicitar la baja:");
		    long document = personValidator.validDocument(Utils.getReader().nextLine());

		   
		    PartnerDto partnerDto = this.service.findPartnerByDocument(document);

		    if (partnerDto == null) {
		        System.out.println("No se ha encontrado un socio con el documento proporcionado.");
		        return;
		    }

		  
		    InvoiceDto pendingInvoice = this.service.findPendingInvoiceByPartner(partnerDto.getId());
		    if (pendingInvoice != null && !pendingInvoice.isStatus()) {
		        System.out.println("El socio tiene facturas pendientes. No puede ser convertido en invitado hasta que las facturas sean pagadas.");
		        return;
		    }

		    GuestDto guestDto = new GuestDto();
		    guestDto.setUserId(partnerDto.getUserTol());  
		    guestDto.setPartnerId(null);  
		    guestDto.setStatus(true);  

		    this.service.createGuest(guestDto);

		    this.service.disablePartner(partnerDto.getId());

		    System.out.println("El socio ha sido convertido exitosamente en invitado.");
		}


    }
    

	
