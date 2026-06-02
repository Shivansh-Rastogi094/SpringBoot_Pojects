package Demo.model;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements ICoach {

@Override
public String getDailyProject() {
	return "Play Badminton : Practice serving and smashing";	
	}
}




