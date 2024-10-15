package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.Repository.GuestRepository;
import app.dao.interfaces.GuestDao;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service

public class GuestDaoImplementation implements GuestDao{
	@Autowired
	public GuestRepository guestRepository;

	@Override
	public long FindById(GuestDto guestDto) throws Exception {
		return 0;
	}

	@Override
	public GuestDto byUserId(GuestDto guestDto) throws Exception {
		Guest guest =guestRepository.findByUserId(Helper.parse(guestDto.getUserId()));
		return Helper.parse(guest);
		
	}

	@Override
	public PartnerDto byPartnerId(GuestDto guestDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean byStatus(GuestDto guestDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		guestRepository.save(guest);
		
	}

	@Override
	public void deleteGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		guestRepository.delete(guest);
		
	}

	@Override
	public GuestDto findByUserId(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activateGuest(GuestDto guestDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableGuest(GuestDto guestDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
