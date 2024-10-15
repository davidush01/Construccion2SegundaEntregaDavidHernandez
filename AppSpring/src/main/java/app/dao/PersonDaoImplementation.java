package app.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.Repository.PersonRepository;
import app.dao.interfaces.PersonDao;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PersonDaoImplementation implements PersonDao {
	@Autowired
	public PersonRepository personRepository;

	@Override
	public boolean existsByDocument(PersonDto personDto) throws Exception {
		 return personRepository.existsByDocument(personDto.getDocument());
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		personRepository.save(person);
		personDto.setId(person.getId());
	}

	@Override
	public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		personRepository.delete(person);
	}

	@Override
	public PersonDto findById(PersonDto personDto) throws Exception {
		Person person =personRepository.findById(personDto.getDocument());
		return Helper.parse(person);
	}

	@Override
	public String name(PersonDto personDto) throws Exception {
		
		return null;
	}

	@Override
	public long findCellphone(PersonDto personDto) throws Exception {
		
		return 0;
	}

	@Override
	public PersonDto findByDocument(PersonDto personDto) throws Exception {
		Person person =personRepository.findById(personDto.getDocument());
		return Helper.parse(person);
	}
}

		
	

