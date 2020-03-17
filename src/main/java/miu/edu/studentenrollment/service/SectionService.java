package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Section;

import java.util.List;

public interface SectionService {

    public Section createSection(Section section) throws Exception;

    public List<Section> viewAllSection();

    public Section editSection(Section section) throws Exception;

    public Section findOneSection(Long id) throws Exception;
}
