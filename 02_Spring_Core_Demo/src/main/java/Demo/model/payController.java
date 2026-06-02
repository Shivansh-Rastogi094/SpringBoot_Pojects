package Demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class payController {
	private paymentMethod payment;
	@Autowired
	public payController(@Qualifier("cash") paymentMethod payment1,@Qualifier("cash") paymentMethod payment2) {
		this.payment=payment1;
		this.payment=payment2;
		System.out.println(
			    (payment1 == payment2)
			    ? "same object is passed"
			    : "different object is passed"
			);
		
	}
	@GetMapping("/pay")
	public String Payment() {
		return payment.pay();
	}
	

}