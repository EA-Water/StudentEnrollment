package miu.edu.studentenrollment.domain;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String studentId;
    private String studentName;

    @Email
    private String studentEmail;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollment;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mailing_address_id")
    private Address mailingAddress;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="home_address_id")
    private Address homeAddress;


    @Valid
    @ManyToOne
    @JoinColumn(name ="entry_id")
    private Entry entry;



    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public List<Enrollment> getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(List<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
