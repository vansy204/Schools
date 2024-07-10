package org.example.schools.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class StaffDetailDTO {
    private Long id;
    private Long identificationNumber;
    private String address;
    private Date dateStartJob;
    private double salary;
    private String facebook;
    private String zalo;
    private Long phone;
    private boolean partyMember;
    private int numberOfYearOfExperience;
    private String gratuatedFrom;
    private String password;
}
