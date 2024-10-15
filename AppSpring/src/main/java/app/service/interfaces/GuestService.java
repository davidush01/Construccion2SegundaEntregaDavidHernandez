package app.service.interfaces;

import java.util.List;

import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;

public interface GuestService {
	public void createbecomepartner(GuestDto guestDto) throws Exception;

	public GuestDto findGuestByDocument(String guestDocument);

	public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
	 public void createInvoice(InvoiceDto invoiceDto) throws Exception;
	 public void promoteGuestToPartner(PartnerDto partnerDto) throws Exception;
	}



