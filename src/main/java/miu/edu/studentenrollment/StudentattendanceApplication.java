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
		Role role = new Role("admin");
		List<Role> roleList = Arrays.asList(role);

		User user = new User("admin","admin123","jeandelapaixd@gmail.com",roleList);
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		userRepo.save(user);

	}



}
