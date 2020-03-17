package miu.edu.studentenrollment.domain;


import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Offering {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String offeringCode;


    @Valid
    @ManyToOne
    @JoinColumn(name="block_id")
    private Block block;
    @Valid
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferingCode() {
        return offeringCode;
    }

    public void setOfferingCode(String offeringCode) {
        this.offeringCode = offeringCode;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
