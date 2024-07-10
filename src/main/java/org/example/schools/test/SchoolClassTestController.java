package org.example.schools.test;


import jakarta.transaction.Transactional;
import org.example.schools.Service.SchoolClassService;
import org.example.schools.dto.SchoolClassDTO;
import org.example.schools.entity.SchoolClass;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "schoolclass")

public class SchoolClassTestController {
    SchoolClassService schoolClassService;
    private ModelMapper modelMapper;
    @Autowired
    public void setSchoolClassService(SchoolClassService schoolClassService,ModelMapper modelMapper) {
        this.schoolClassService = schoolClassService;
        this.modelMapper = modelMapper;

    }

    @GetMapping("/getAllClass")
    public List<SchoolClassDTO> getAllClass() {
        List<SchoolClass> schoolClassList = schoolClassService.getAllClasses();
        return schoolClassList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/getClassByClassName/{className}")
    public SchoolClassDTO getClassByClassName(@PathVariable String className) {
        Optional<SchoolClass> schoolClass = schoolClassService.getClassByName(className);
        return convertToDto(schoolClass.orElse(null));
    }
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<SchoolClassDTO> save(@RequestBody SchoolClassDTO schoolClassDTO) {

        SchoolClass schoolClass = convertToEntity(schoolClassDTO);
        schoolClassService.save(schoolClass);
        return ResponseEntity.ok(convertToDto(schoolClass));
    }

    @PostMapping("/update/{className}")
    @Transactional
    public SchoolClass update(@PathVariable String className, @RequestBody SchoolClassDTO schoolClassDTO) throws RuntimeException {
        Optional<SchoolClass> schoolClass = schoolClassService.getClassByName(className);
        if(schoolClass.isEmpty()){
            throw new RuntimeException("School class not found with name: " + className);
        }
        SchoolClass schoolClasstoUpdate = schoolClass.get();
        updateEntityFromDto(schoolClasstoUpdate,schoolClassDTO);
        schoolClassService.save(schoolClasstoUpdate);
        return schoolClasstoUpdate;
    }
    @DeleteMapping("/delete/{className}")
    @Transactional
    public void delete(@PathVariable String className) throws RuntimeException {
        Optional<SchoolClass> schoolClass = schoolClassService.getClassByName(className);
        if(schoolClass.isEmpty()){
            throw new RuntimeException("School class not found with name: " + className);
        }
        schoolClassService.delete(schoolClass.get());
    }
    public void updateEntityFromDto(SchoolClass schoolClass,SchoolClassDTO schoolClassDTO) {
        if(schoolClass.getClassRank() != schoolClassDTO.getClassRank() && schoolClassDTO.getClassRank() != 0){
            schoolClass.setClassRank(schoolClassDTO.getClassRank());
        }
        if(schoolClass.getSchoolYear() != schoolClassDTO.getSchoolYear() && schoolClassDTO.getSchoolYear() != null){
            schoolClass.setSchoolYear(schoolClassDTO.getSchoolYear());
        }
        if(schoolClass.getNumberOfClass() != schoolClassDTO.getNumberOfClass() && schoolClassDTO.getNumberOfClass() != 0){
            schoolClass.setNumberOfClass(schoolClassDTO.getNumberOfClass());
        }
        if(schoolClass.getBlock() != schoolClassDTO.getBlock() && schoolClassDTO.getBlock() != 0){
            schoolClass.setBlock(schoolClassDTO.getBlock());
        }
    }
    private SchoolClassDTO convertToDto(SchoolClass schoolClass) {
        return modelMapper.map(schoolClass, SchoolClassDTO.class);
    }
    private SchoolClass convertToEntity(SchoolClassDTO schoolClassDTO) {
        return modelMapper.map(schoolClassDTO, SchoolClass.class);
    }
}
