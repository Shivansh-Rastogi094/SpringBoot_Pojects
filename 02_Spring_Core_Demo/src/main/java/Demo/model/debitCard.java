package Demo.model;

import org.springframework.stereotype.Controller;

@Controller
public class debitCard implements paymentMethod{
public String pay() {
	return ("Payment done via Debit Card");
}

public debitCard() {
	System.out.println("Inside debit card");
}
}
