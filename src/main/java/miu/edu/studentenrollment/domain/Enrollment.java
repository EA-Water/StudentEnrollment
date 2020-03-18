package miu.edu.studentenrollment.domain;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

>>>>>>> 31a43ef9a0509d37f1ee9e2a47d30134c3642a9a
import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Valid
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private Student student;

    @JsonIgnore
    @Valid
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="section_id")
    private Section section;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
