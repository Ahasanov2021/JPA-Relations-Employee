package az.ingress.demo;


import az.ingress.demo.model.*;
//import az.ingress.demo.repository.BalanceRepository;
import az.ingress.demo.repository.EmailRepository;
import az.ingress.demo.repository.PhoneRepository;
import az.ingress.demo.repository.RoleRepository;
import az.ingress.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Transactional
public class DemoApplication implements CommandLineRunner {


	private final EmployeeRepository employeeRepository;
	private final PhoneRepository phoneRepository;
	private final EmailRepository emailRepository;

//	private final BalanceRepository balanceRepository;
	private final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {


		Phone phone1 = Phone.builder()
				.number("9942455454454")
				.build();
		phoneRepository.save(phone1);

		Phone phone2 = Phone.builder()
				.number("9948454986683")
				.build();
		phoneRepository.save(phone2);

		Phone phone3 = Phone.builder()
				.number("99445487979975")
				.build();
		phoneRepository.save(phone3);

		Email email1 = Email.builder()
				.email("ali@gmail.com")
				.build();
		emailRepository.save(email1);

		Email email2 = Email.builder()
				.email("hasan@gmail.com")
				.build();
		emailRepository.save(email2);

		Role user = Role.builder()
				.role("user")
				.build();

		Role admin = Role.builder()
				.role("admin")
				.build();

		roleRepository.save(user);
		roleRepository.save(admin);

		Role userRole  = roleRepository.findByRole("user").get();
		Role adminRole = roleRepository.findByRole("admin").get();

		Employee employee = Employee.builder()
				.name("Ali")
				.gender(Gender.MALE)
				.roles(List.of(userRole, adminRole))
				.age(25)
				.lastname("Hasanov")
				.build();
		employeeRepository.save(employee);

		Employee employee1 = Employee.builder()
				.name("Hasan")
				.gender(Gender.MALE)
				.roles(List.of(userRole))
				.age(20)
				.lastname("Hasanov")
				.build();
		employeeRepository.save(employee1);

		phone1.setEmployee(employee);
		phone2.setEmployee(employee);
		phone3.setEmployee(employee1);
		email1.setEmployee(employee);
		email2.setEmployee(employee1);
//
//		phoneRepository.saveAll(List.of(phone1, phone2, phone3));
//		emailRepository.saveAll(List.of(email1, email2));
//		userRepository.save(employee);
//		userRepository.save(employee1);

		//-----------------------------------


//		Student student = studentRepository.findById(2).get();
//		Phone build = Phone.builder()
//				.number("4648497987987")
//				.student(student)
//				.build();
//
//		student.getPhoneList().add(build);
//
//		studentRepository.save(student);


////
//		Student student = Student.builder()
//				.name("Hasan")
//				.age(25)
//				.lastname("Hasanov")
//				.roles(List.of(user))
//				.build();
//		studentRepository.save(student);

//		studentRepository.deleteById(1);


//		System.out.println(student);

//		Phone phone = phoneRepository.findById(1).get();
//		System.out.println(phone);
//		System.out.println(phone.getStudent());



	}
}
