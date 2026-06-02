package Demo.model;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements ICoach {

@Override
public String getDailyProject() {
	return "Play Football : Practice shooting and tackling";	
	}
}
