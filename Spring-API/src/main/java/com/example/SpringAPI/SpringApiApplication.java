package com.example.SpringAPI;

import com.example.SpringAPI.model.Employee;
import com.example.SpringAPI.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(SpringApiApplication.class, args);}


	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Madhubhashana");
		employee.setLastName("Mahindarathna");
		employee.setEmailId("madhubhashana99@gmail.com");
		employeeRepo.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Hasali");
		employee1.setLastName("Asinsana");
		employee1.setEmailId("Hasali@gmail.com");
		employeeRepo.save(employee1);
	}
}
