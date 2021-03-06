package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findBySection(Section section);
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Enrollment e WHERE e.student.id = :studentId AND e.section.id = :sectionId")
	boolean existsByStudentAndSection(@Param("sectionId")Long sectionId, @Param("studentId")Long studentId);

}
