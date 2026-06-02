package com.monocept;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.monocept.Dao.EmployeeDao;
import com.monocept.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao employeeDao) {
		return runner -> {

			// createEmp(employeeDao);

			 //findEmpById(employeeDao);

//			 findAllEmp(employeeDao);

			// findEmpByAge(employeeDao);

			// findEmpByCity(employeeDao);

			// findEmpByName(employeeDao);

			// findEmpBySalary(employeeDao);
			 
			//deleteEmpById(employeeDao);
			
			updateEmpSalById(employeeDao);
			 
		};
	}

	private void updateEmpSalById(EmployeeDao employeeDao) {
				System.out.println("Updating Employee");
				Employee tempEmp=employeeDao.updateSalaryBYId(2);
				System.out.println("Updated Employee: "+tempEmp);
	}

	private void deleteEmpById(EmployeeDao employeeDao) {
		System.out.println("Deleting Employee");
		employeeDao.deleteEmployeeBYId(1);
		System.out.println("Employee Deleted");
	}

	private void createEmp(EmployeeDao employeeDao) {

		System.out.println("Creating a new Employee");

		Employee tempEmp = new Employee(
				"Rohit Mishra",
				"Lucknow",
				226004,
				50000,
				23,
				"RohitMishra@gmail.com");

		System.out.println("Saving new Employee");

		employeeDao.insertEmployee(tempEmp);

		System.out.println(
				"Employee Generated : Generated Employee = "
						+ tempEmp.getEmpId());
	}

	private void findEmpById(EmployeeDao employeeDao) {

		System.out.println("Finding Employee By ID");

		Employee tempEmp = employeeDao.findEmployeeById(1);

		System.out.println("Found : " + tempEmp);
	}

	private void findAllEmp(EmployeeDao employeeDao) {

		System.out.println("Finding All Employees");

		List<Employee> employees =
				employeeDao.findAllEmployee();

		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}

	private void findEmpByAge(EmployeeDao employeeDao) {

		System.out.println("Finding Employees By Age");

		List<Employee> employees =
				employeeDao.findEmployeeBYAge(23);

		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}

	private void findEmpByCity(EmployeeDao employeeDao) {

		System.out.println("Finding Employees By City Code");

		List<Employee> employees =
				employeeDao.findEmployeeBYCity(226004);

		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}

	private void findEmpByName(EmployeeDao employeeDao) {

		System.out.println("Finding Employees By Name");

		List<Employee> employees =
				employeeDao.findEmployeeBYName("Rohit");

		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}

	private void findEmpBySalary(EmployeeDao employeeDao) {

		System.out.println("Finding Employees By Salary");

		List<Employee> employees =
				employeeDao.findEmployeeBYSalary(50000);

		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}
}