package org.example.schools.test;


import jakarta.transaction.Transactional;
import org.example.schools.Service.SchoolClassService;
import org.example.schools.dto.SchoolClassDTO;
import org.example.schools.entity.SchoolClass;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping("/save")
    @Transactional
    public SchoolClassDTO save(@RequestBody SchoolClassDTO  schoolClassDTO) {
        SchoolClass schoolClass = convertToEntity(schoolClassDTO);
        schoolClassService.save(schoolClass);
        return schoolClassDTO;
    }
    private SchoolClassDTO convertToDto(SchoolClass schoolClass) {
        return modelMapper.map(schoolClass, SchoolClassDTO.class);
    }
    private SchoolClass convertToEntity(SchoolClassDTO schoolClassDTO) {
        return modelMapper.map(schoolClassDTO, SchoolClass.class);
    }
}
