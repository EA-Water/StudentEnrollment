package miu.edu.studentenrollment.domain;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
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
    private Date enrollmnetStartDate;
    @Future
    private Date enrollmnetEndDate;

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

    public Date getEnrollmnetStartDate() {
        return enrollmnetStartDate;
    }

    public void setEnrollmnetStartDate(Date enrollmnetStartDate) {
        this.enrollmnetStartDate = enrollmnetStartDate;
    }

    public Date getEnrollmnetEndDate() {
        return enrollmnetEndDate;
    }

    public void setEnrollmnetEndDate(Date enrollmnetEndDate) {
        this.enrollmnetEndDate = enrollmnetEndDate;
    }

    public List<Student> getStudentList() {
        return studentList;
    }



}
