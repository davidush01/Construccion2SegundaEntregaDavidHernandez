package app.dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Guest;
import app.model.User;

public interface GuestRepository extends JpaRepository<Guest,Long> {

	public Guest findById(long id);

	public Guest findByUserId(User userId); 
	
	

}

	
