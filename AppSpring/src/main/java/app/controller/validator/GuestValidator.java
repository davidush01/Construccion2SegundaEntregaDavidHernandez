package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Component
public class GuestValidator extends CommonsValidator{

	
	
	public boolean validStatus(boolean status) throws Exception {
	    
	    return status;
	}
	
	
	

}
