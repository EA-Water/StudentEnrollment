package miu.edu.studentenrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.studentenrollment.domain.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
