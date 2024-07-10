package org.example.schools.dto;

import lombok.Data;
import org.example.schools.entity.StaffDetail;

import java.sql.Date;

@Data
public class StaffDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String role;
    private String email;
    private String position;
    private StaffDetailDTO staffDetailDTO;
}
