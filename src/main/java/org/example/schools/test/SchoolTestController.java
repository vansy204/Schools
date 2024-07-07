package org.example.schools.test;

import jakarta.transaction.Transactional;
import org.example.schools.Service.SchoolService;
import org.example.schools.dto.SchoolDTO;
import org.example.schools.entity.School;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/school")
public class SchoolTestController {
    private SchoolService schoolService;
    private ModelMapper modelMapper;
    @Autowired
    public SchoolTestController(SchoolService schoolService,ModelMapper modelMapper) {
        this.schoolService = schoolService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/getAllSchool")
    public List<SchoolDTO> getAllSchool() {
        List<School> schools = schoolService.findAll();
        return schools.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    @GetMapping("/getSchoolById/{id}")
    public Optional<School> get(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }
    @GetMapping("/getByName/{schoolName}")
    public Stream<SchoolDTO> getSchoolByName(@PathVariable String schoolName) {
        return Optional.ofNullable(schoolService.getSchoolByName(schoolName)).stream().map(this::convertToDTO);
    }
    @PostMapping("/save")
    @Transactional
    public SchoolDTO save(@RequestBody SchoolDTO schoolDTO) {
        School  school = convertToEntity(schoolDTO);
        schoolService.saveSchool(school);
        return schoolDTO;
    }
    @PostMapping("/update/{id}")
    @Transactional
    public School update(@PathVariable Long id, @RequestBody SchoolDTO schoolDTO) throws RuntimeException{
        Optional<School> optionalSchool = schoolService.getSchoolById(id);
        if (optionalSchool.isEmpty()) {
            throw new RuntimeException("School not found with id: " + id);
        }
        School schoolToUpdate = optionalSchool.get();
        updateEntityFromDto(schoolToUpdate, schoolDTO);
        schoolService.saveSchool(schoolToUpdate);
        return schoolToUpdate;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
    private void updateEntityFromDto(School school, SchoolDTO schoolDTO) {
        schoolDTO.setId(school.getId());
        if (schoolDTO.getName() != null) {
            school.setName(schoolDTO.getName());
        }
        if (schoolDTO.getAddress() != null) {
            school.setAddress(schoolDTO.getAddress());
        }
        if(schoolDTO.getSchoolDetail() != null){
            school.setSchoolDetail(schoolDTO.getSchoolDetail());
        }
        if(schoolDTO.getPhone() != null){
            school.setPhone(schoolDTO.getPhone());
        }
    }
    private SchoolDTO convertToDTO(School school) {
        return modelMapper.map(school, SchoolDTO.class);
    }
    private School convertToEntity(SchoolDTO schoolDTO) {
        return modelMapper.map(schoolDTO, School.class);
    }

}
