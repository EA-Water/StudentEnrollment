package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
