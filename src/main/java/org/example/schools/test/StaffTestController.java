package org.example.schools.test;

import org.example.schools.Service.StaffService;
import org.example.schools.dao.StaffRepository;
import org.example.schools.dto.StaffDTO;
import org.example.schools.entity.Staff;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff")
public class StaffTestController {
    private final ModelMapper modelMapper;
    StaffService staffService;
    StaffRepository staffRepository;
    @Autowired
    public StaffTestController(StaffService staffService, StaffRepository staffRepository, ModelMapper modelMapper) {
        this.staffService = staffService;
        this.staffRepository = staffRepository;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/getAllStaff")
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffs = staffRepository.findAll();
        return staffs.stream().map(this::convertStaffToStaffDTO).collect(Collectors.toList());
    }
    private StaffDTO convertStaffToStaffDTO(Staff staff) {
        return modelMapper.map(staff, StaffDTO.class);
    }
    private Staff convertStaffDTOToStaff(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, Staff.class);
    }
}
