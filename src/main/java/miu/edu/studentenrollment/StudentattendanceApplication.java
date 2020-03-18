package miu.edu.studentenrollment;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.domain.Course;
import miu.edu.studentenrollment.domain.Role;
import miu.edu.studentenrollment.domain.User;
import miu.edu.studentenrollment.repository.UserRepo;
import miu.edu.studentenrollment.service.BlockService;
import miu.edu.studentenrollment.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentattendanceApplication {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(StudentattendanceApplication.class, args);
	}

	@PostConstruct
	public void initUsers(){
		Role roleAdmin = new Role("ADMIN");
		Role roleStudent = new Role("STUDENT");
		Role roleFaculty = new Role("FACULTY");

		List<Role> adminOnly = Arrays.asList(roleAdmin);
		List<Role> studentOnly = Arrays.asList(roleStudent);
		List<Role> facultyOnly = Arrays.asList(roleFaculty);

		User admin = new User("admin","admin123","jeandelapaixd@gmail.com",adminOnly);
		admin.setPassword(bcryptEncoder.encode(admin.getPassword()));
		userRepo.save(admin);

		User faculty1 = new User("faculty","faculty123","faculty1@miu.edu",facultyOnly);
		faculty1.setPassword(bcryptEncoder.encode(faculty1.getPassword()));


		User student1 = new User("jean","jean123","jeandelapaixd@gmail.com",studentOnly);
		student1.setPassword(bcryptEncoder.encode(student1.getPassword()));

		userRepo.save(faculty1);
		userRepo.save(student1);
	}

}
