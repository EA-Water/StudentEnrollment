package miu.edu.studentenrollment.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
public class Section {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "section")
    private List<Enrollment> enrollmentList;

    @Valid
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="faculty_id")
    private Faculty faculty;


    @ManyToOne
    @JoinColumn(name="offering_id")
    private Offering offering;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }


}
