package org.example.schools.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.schools.entity.SchoolClass;
import org.example.schools.entity.SchoolDetail;
import org.example.schools.entity.Staff;
import org.example.schools.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
public class SchoolDTO {

  private long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shool_detail_id")
  private SchoolDetail schoolDetail;
  private String phone;
  private String address;
  private String name;



}
