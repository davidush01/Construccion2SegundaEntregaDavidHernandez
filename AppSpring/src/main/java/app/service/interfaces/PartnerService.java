package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.UserDto;

public interface PartnerService {
	public void createGuest (GuestDto guestDto) throws Exception;
    public void disableGuest(long document) throws Exception;
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    public void activateGuest(long document) throws Exception;
    public void incrementAmount(PartnerDto partnerDto) throws Exception;
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
}

