package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.Repository.UserRepository;
import app.dao.interfaces.UserDao;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;

import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class UserDaoImplementation implements UserDao {
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDto findByUserName(UserDto UserDto) throws Exception {
		User user = userRepository.findByUserName(UserDto.getUserName());
		return Helper.parse(user);
		
	}

	@Override
	public boolean existsByUserName(UserDto UserDto) throws Exception {
		return userRepository.existsByUserName(UserDto.getUserName());
		
	}
	
	@Override
	public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        userRepository.save(user);
        userDto.setId(user.getId());
	}

	@Override
	public long byId(UserDto UserDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String findpassword(UserDto UserDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String role(UserDto UserDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDto personId(UserDto UserDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deleteUser(UserDto userDto) throws Exception {
		 User user = Helper.parse(userDto);
	     userRepository.delete(user);
	// TODO Auto-generated method stub
		
	}

	@Override
	public void convertPartner(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto findByPersonId(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
