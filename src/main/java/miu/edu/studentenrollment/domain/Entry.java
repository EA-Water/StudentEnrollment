package miu.edu.studentenrollment.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.util.Date;
import java.util.List;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String entryName;
    @FutureOrPresent
    private Date entryStartDate;
    @Future
    private Date enrollmentStartDate;
    @Future
    private Date enrollmentEndDate;

    @OneToMany(mappedBy = "entry")
//    @Immutable
    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public Date getEntryStartDate() {
        return entryStartDate;
    }

    public void setEntryStartDate(Date entryStartDate) {
        this.entryStartDate = entryStartDate;
    }

    public Date getEnrollmentStartDate() {
        return enrollmentStartDate;
    }

    public void setEnrollmentStartDate(Date enrollmnetStartDate) {
        this.enrollmentStartDate = enrollmnetStartDate;
    }

    public Date getEnrollmentEndDate() {
        return enrollmentEndDate;
    }

    public void setEnrollmentEndDate(Date enrollmnetEndDate) {
        this.enrollmentEndDate = enrollmnetEndDate;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}
