package app.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;

import app.controller.validator.DetailValidator;
import app.controller.validator.GuestValidator;
import app.controller.validator.InvoiceValidator;
import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.dao.PersonDaoImplementation;
import app.dao.interfaces.PersonDao;
import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.GuestService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@Controller
public class GuestController implements ControllerInterfaces {
     private List<InvoiceDto> invoiceList = new ArrayList<>();
	private PersonValidator personValidator;
	private PartnerValidator partnerValidator;
	private InvoiceValidator invoiceValidator;
	private DetailValidator detailValidator;
	private GuestValidator guestValidator;
	private GuestService  service;
	private PersonDao personDao;
	private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1. para crear factura. \n 2. para promover invitado a socio. \n 3 para cerrar sesion";
	
	ClubService partnerDto = new ClubService();
	
	@Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = guestSession();
		}

	}
	
	private boolean guestSession() {
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
			this.createInvoiceGuest();
			return true;
		}
		case "2": {
			this.promoteGuestToPartner();
			return true;
		}
		case "3": {
			System.out.println("se ha cerrado sesion");
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

	private void createInvoiceGuest() throws Exception {
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
	    invoiceHistory(invoiceDto, invoiceDetailDto); // Llama al método para mostrar detalles
	    System.out.println("Se ha creado la factura exitosamente.");
	}

        
        
	
	

	public void promoteGuestToPartner() throws Exception {

	        PartnerDto parnetDto = new PartnerDto();
	        UserDto userDto = new UserDto();
	        System.out.println("ingrese el fondo");
	        double amount = invoiceValidator.validAmount(Utils.getReader().nextLine());
	        parnetDto.setUserTol(userDto);
	        parnetDto.setAmount(amount);
	        parnetDto.setType(true);
	        parnetDto.setCreationDate(Utils.getDate());
	        this.service.promoteGuestToPartner(parnetDto);
	        
	        

	    System.out.println("El invitado ha sido promovido a socio exitosamente.");
	}
        
        /*  public void invoiceHistory() {
        if (invoiceList.isEmpty()) {
            System.out.println("No hay facturas registradas.");
        } else {
            for (InvoiceDto invoice : invoiceList) {
                System.out.println("Factura ID: " + invoice.getId());
                System.out.println("Fecha de creación: " + invoice.getCreationDate());
                System.out.println("Monto total: " + invoice.getAmount());
                System.out.println("Estado: " + invoice.isStatus());
                System.out.println("--------------------------------");
            }
        }
    }*/

	
	
	


}
