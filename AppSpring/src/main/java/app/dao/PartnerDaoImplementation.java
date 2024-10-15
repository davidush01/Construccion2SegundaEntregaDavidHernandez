package app.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.Repository.PartnerRepository;
import app.dao.interfaces.PartnerDao;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.dao.interfaces.UserDao;
import app.helpers.Helper;
import app.model.Partner;
import app.model.Person;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PartnerDaoImplementation implements PartnerDao {
	@Autowired
	 public PartnerRepository partnerRepository;

	public boolean existsByUserId(PartnerDto partnerDto) throws Exception {
		return partnerRepository.existsByUserId(Helper.parse(partnerDto.getUserTol()));
    }

	 @Override
	    public void createPartner(PartnerDto partnerDto) throws Exception {
	        Partner partner = Helper.parse(partnerDto);
	        partnerRepository.save(partner);
	 }

	 @Override
	    public void deletePartner(PartnerDto partnerDto) throws Exception {
	        Partner partner = Helper.parse(partnerDto);
	        partnerRepository.delete(partner);
	    }
	 @Override
	    public PartnerDto findById(PartnerDto partnerDto) throws Exception {
		 Partner partner =partnerRepository.findById(partnerDto.getId());
			return Helper.parse(partner);
	    }
	
	 @Override
	    public PartnerDto findByUserId(PartnerDto partnerDto) throws Exception {
	       Partner partner = partnerRepository.findByUserId(Helper.parse(partnerDto.getUserTol()));
	       return Helper.parse(partner);
	    }

	

	@Override
	public double amount(PartnerDto partnerDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	    }

	@Override
	public boolean type(PartnerDto partnerDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	    }

	@Override
	public Date creationDate(PartnerDto partnerDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	    }

	@Override
	public UserDto userTol(PartnerDto PartnerDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	    }

	@Override
	public PersonDto findByDocument(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	    }

    @Override
    public PartnerDto findByUserId(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	@Override
	public void incrementAmount(PartnerDto partnerDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePartner(PartnerDto partnerDto) throws Exception {
		// TODO Auto-generated method stub
		
	}
	


	


	


}
