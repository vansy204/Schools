package org.example.schools.test;

import org.example.schools.Service.SchoolService;
import org.example.schools.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TestController {
    SchoolService schoolService;
    @Autowired
    public TestController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping("/get")
    public List<School> get() {
        return schoolService.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<School> get(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }
    @GetMapping("/getByName/{schoolName}")
    public Optional<School> getSchoolByName(@PathVariable String schoolName) {
        return Optional.ofNullable(schoolService.getSchoolByName(schoolName));
    }
    @PutMapping("/save")
    public School save(@RequestBody School school) {
        schoolService.saveSchool(school);
        return school;
    }
    @PutMapping("/update/{id}")
    public School update(@PathVariable Long id, @RequestBody School school) {
        school.setId(id);
        schoolService.saveSchool(school);
        return school;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}
