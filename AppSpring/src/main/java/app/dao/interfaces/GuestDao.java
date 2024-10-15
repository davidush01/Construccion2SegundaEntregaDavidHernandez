package app.dao.interfaces;

import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.UserDto;

public interface GuestDao {
	public long FindById (GuestDto GuestDto)throws Exception;
	public GuestDto byUserId(GuestDto GuestDto)throws Exception;
	public PartnerDto byPartnerId (GuestDto GuestDto)throws Exception;
	public boolean byStatus (GuestDto GuestDto)throws Exception;
    
	
	public void createGuest(GuestDto GuestDto) throws Exception;
	public void deleteGuest(GuestDto GuestDto) throws Exception;
	 public GuestDto findByUserId(UserDto userDto) throws Exception;
	 public void activateGuest(GuestDto guestDto) throws Exception;
	 public void disableGuest(GuestDto guestDto) throws Exception;
}
