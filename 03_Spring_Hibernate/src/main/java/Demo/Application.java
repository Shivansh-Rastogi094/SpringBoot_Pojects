package Demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Demo.Dao.StudentDao;
import Demo.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
//			createStudent(studentDao);
//			foundStudent(studentDao);
			List<Student> students =
			        studentDao.findByName("shiv");

			for(Student s : students) {
			    System.out.println(s);
			}
		};
	}


	private void foundStudent(StudentDao studentDao) {
		System.out.println("Lets fidn Student");
		Student findById = studentDao.findId(1);
		System.out.println("Found :" +findById);
	}


	private void createStudent(StudentDao studentDao) {
		System.out.println("Creating a studend");
		Student tempStudent = new Student("Shivansh", "Verma");
		System.out.println("Saving Student");
		studentDao.save(tempStudent);
		System.out.println("Student Generated : Generated Student =" +tempStudent.getId());
	}
}
