package org.example.schools.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.schools.entity.SchoolClass;
import org.example.schools.entity.Staff;
import org.example.schools.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
public class SchoolClassDTO {
  private String className;
  private long block;
  private long classRank;
  private long numberOfClass;
  private String schoolYear;
  @OneToOne(cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE,
          CascadeType.DETACH,
          CascadeType.REFRESH,
  },
          fetch = FetchType.LAZY
  )
  @JsonManagedReference
  private Staff homeRoomTeacher;
}
