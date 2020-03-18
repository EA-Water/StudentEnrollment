package miu.edu.studentenrollment.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Offering {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String offeringCode;
<<<<<<< HEAD
    
=======


    @JsonIgnore
>>>>>>> 31a43ef9a0509d37f1ee9e2a47d30134c3642a9a
    @Valid
    @ManyToOne
    @JoinColumn(name="block_id")
    private Block block;
<<<<<<< HEAD
    
=======
    @JsonIgnore
>>>>>>> 31a43ef9a0509d37f1ee9e2a47d30134c3642a9a
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

	@Override
	public String toString() {
		return "Offering [id=" + id + ", offeringCode=" + offeringCode + ", block=" + block + ", course=" + course
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((offeringCode == null) ? 0 : offeringCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offering other = (Offering) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (offeringCode == null) {
			if (other.offeringCode != null)
				return false;
		} else if (!offeringCode.equals(other.offeringCode))
			return false;
		return true;
	}
	
    
}
