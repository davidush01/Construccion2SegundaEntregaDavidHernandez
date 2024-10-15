package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InvoiceValidator extends CommonsValidator{

	
	public void validItems(String items)throws Exception {
		super.isValidString("items de la factura", items);
	}
	
	public double validAmount(String amount) throws Exception{
		return super.isValidDouble("el monto de la factura ", amount);
	}
	
	
	public boolean validStatus(double status)throws Exception {
		return super.isValidboolean("la factura es " + status);
	}
	public void validDescription(String description) throws Exception {
        super.isValidString("La descripcion de la factura", description);
    }
    
    public int validItem(String item) throws Exception{
        return super.isValidInteger("item item de la factura", item);
    }

	

}
