package app.service.interfaces;

import app.dto.PartnerDto;
import app.dto.UserDto;

public interface AdminService {
	public void createPartnerRegistration(PartnerDto partnerdto) throws Exception;

	public void createViewInvoiceHistory(UserDto userDto) throws Exception;

	public void vipPromotion(UserDto userDto) throws Exception;
	
	
}
 