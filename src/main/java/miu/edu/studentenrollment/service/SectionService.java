package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Section;

import java.util.List;

public interface SectionService {

    public Section createSection(Section section) throws Exception;

    public List<Section> getAllSections();

    public Section updateSection(Section section, Long id) throws Exception;

    public Section getSectionById(Long id) throws Exception;
}
