package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.repository.SectionRepo;
import miu.edu.studentenrollment.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepo sectionRepo;

    @Override
    public Section createSection(Section section) throws Exception {

        try {
            return sectionRepo.save(section);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Section> viewAllSection() {
        return sectionRepo.findAll();
    }


    @Override
    public Section editSection(Section section) throws Exception {

        Section foundSection = sectionRepo.getOne(section.getId());

        if(foundSection== null){
            throw new Exception("Invalid section id");
        }
        return sectionRepo.save(foundSection);
    }

    @Override
    public Section findOneSection(Long id) throws Exception {
        Section foundSection = sectionRepo.getOne(id);

        if(foundSection== null){
            throw new Exception("Invalid section id");
        }
        return foundSection;
    }
}
