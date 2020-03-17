package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findBySection(Section section);

}
