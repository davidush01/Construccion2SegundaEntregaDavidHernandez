package app.dao.Repository;

import app.model.Partner;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner,Long> {
	
	public boolean existsByUserId(User l);

	public Partner findById(long id);

	public Partner findByUserId(User user); 
	
	

}


	