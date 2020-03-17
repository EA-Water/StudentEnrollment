package miu.edu.studentenrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Block {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}")
    private String blockCode;
    private String blockName;
    private String blockSemester;
    private String blockSequenceNumber;
    @FutureOrPresent
    private Date startDate;

    @Future
    private Date endDate;

    public Block() {
    }

    public Block(String blockCode,String blockName,String blockSemester,String blockSequenceNumber,Date startDate, Date endDate) {
        this.blockCode = blockCode;
        this.blockName = blockName;
        this.blockSemester = blockSemester;
        this.blockSequenceNumber = blockSequenceNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockSemester() {
        return blockSemester;
    }

    public void setBlockSemester(String blockSemester) {
        this.blockSemester = blockSemester;
    }

    public String getBlockSequenceNumber() {
        return blockSequenceNumber;
    }

    public void setBlockSequenceNumber(String blockSequenceNumber) {
        this.blockSequenceNumber = blockSequenceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
