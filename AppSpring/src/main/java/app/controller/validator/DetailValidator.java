package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class DetailValidator extends CommonsValidator{

	
	public long invoiceId(String invoiceId) throws Exception{
		return super.isValidInteger("el id de el detalle es  ", invoiceId);
	}
	
	public int validitem(String item) throws Exception{
		return super.isValidInteger("los items son ", item);
	}
	
	public void validDescription(String description) throws Exception{
		 super.isValidString("el numero de telefono es ", description);
	}
	
	public double amount(String amount) throws Exception{
		return super.isValidDouble("el monto es   ", amount);
	}
	
	

}
