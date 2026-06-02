package Demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
	
//	@Autowired
//	private ICoach myCoach;   // Field Injection
//	
	private ICoach myCoach; 
	
	@Autowired
	public CoachController(@Qualifier("badmintonCoach") ICoach coach) {
	this.myCoach = coach;   // Constructor Injection
}

	@GetMapping("/dailyWorkout")
	public String getDailyProjectResult() {
		return myCoach.getDailyProject();
	}
}
