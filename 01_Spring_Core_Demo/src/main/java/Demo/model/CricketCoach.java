package Demo.model;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;

@Component
public class CricketCoach implements ICoach {

@Override
public String getDailyProject() {
	return "Play Cricket : Practice Batting and Bowling";	
	}
}
