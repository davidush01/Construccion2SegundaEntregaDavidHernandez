package app.dao.Repository;

import app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
	public boolean existsByDocument(long document);

	public Person findById(long document);
	

}

	
