package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/")
    public List<Section> createSection(@RequestBody Section section){
        List<Section> sectionList = sectionService.getAllSections();
        try {
            sectionList.add(sectionService.createSection(section));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sectionList;
    }


    @PostMapping("/{id}")
    public List<Section> updateSection(@RequestBody Section section, @PathVariable Long id){


        List<Section> sectionList = new ArrayList<>();
        try {
            Section section1 = sectionService.getSectionById(id);
            section1 = section;
            sectionService.updateSection(section1);
            sectionList=sectionService.getAllSections();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sectionList;
    }

    @GetMapping("/")
    public List<Section> viewAll(){
        return sectionService.getAllSections();
    }
}
