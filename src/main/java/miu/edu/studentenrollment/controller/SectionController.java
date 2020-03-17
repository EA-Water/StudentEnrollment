package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/create/section")
    public List<Section> createSection(@RequestBody Section section){
        List<Section> sectionList = sectionService.viewAllSection();
        try {
            sectionList.add(sectionService.createSection(section));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sectionList;
    }


    @PostMapping("/update/section/{id}")
    public List<Section> updateSection(@RequestBody Section section, @PathVariable Long id){


        List<Section> sectionList = new ArrayList<>();
        try {
            Section section1 = sectionService.findOneSection(id);
            section1 = section;
            sectionService.editSection(section1);
            sectionList=sectionService.viewAllSection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sectionList;
    }

    @GetMapping("/view/sections")
    public List<Section> viewAll(){
        return sectionService.viewAllSection();
    }
}
