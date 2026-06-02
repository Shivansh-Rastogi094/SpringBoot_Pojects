package Demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class cash implements paymentMethod{
@Override
public String pay() {
	return ("Payment via Cash");
}

public cash() {
	System.out.println("Inside cash");
}
}
