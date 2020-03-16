package miu.edu.studentenrollment.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    private String gender;
    private Date dob;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="studentprogram_id")
    private StudentProgram studentProgram;


    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public StudentProgram getStudentProgram() {
        return studentProgram;
    }

    public void setStudentProgram(StudentProgram studentProgram) {
        this.studentProgram = studentProgram;
    }
}
