package Demo.model;

import org.springframework.stereotype.Component;

@Component
public class upi implements paymentMethod {	
	@Override
	public String pay() {
		return("payment via UPI");
	}

	public upi() {
		System.out.println("Inside UPI");
	}
	
}
