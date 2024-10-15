package app.dao.interfaces;

import java.sql.Date;

import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;


public interface PartnerDao {
	public PartnerDto findById(PartnerDto partnerDto) throws Exception;
	

	public UserDto userTol(PartnerDto PartnerDto) throws Exception;
	
	public double amount(PartnerDto partnerDto) throws Exception;
	
	public boolean type (PartnerDto partnerDto)throws Exception;
	
	public Date creationDate (PartnerDto partnerDto)throws Exception;
	
	public void createPartner (PartnerDto PartnerDto)throws Exception;
	
	public void deletePartner (PartnerDto partnerDto)throws Exception;
	
	public boolean  existsByUserId (PartnerDto PartnerDto)throws Exception;
	public PersonDto findByDocument(PersonDto personDto) throws Exception ;
	public PartnerDto findByUserId (PartnerDto PartnerDto)throws Exception;

    public PartnerDto findByUserId(UserDto user);
    public void incrementAmount(PartnerDto partnerDto) throws Exception;
    public void disablePartner(PartnerDto partnerDto) throws Exception;
}
	

	
	
	
	
	
	
	
	
