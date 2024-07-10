package org.example.schools.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.schools.entity.School;
import org.example.schools.entity.SchoolClass;
import org.example.schools.entity.Staff;
import org.example.schools.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
public class SchoolClassDTO {
  private String className;
  private int classRank;
  private int block;
  private String schoolYear;
  private int numberOfClass;

}
