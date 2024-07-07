package org.example.schools.dto;

import lombok.Data;

@Data
public class SchoolClass {

  private String className;
  private long block;
  private long classRank;
  private long homeroomTeacherId;
  private String homeroomTeacherName;
  private long numberOfClass;
  private String schoolYear;


  public void SchoolClassDTO(SchoolClass){
      
  }


}
