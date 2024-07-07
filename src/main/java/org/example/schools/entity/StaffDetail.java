package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "staff_detail")
@Data
public class StaffDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "identification_number")
    private Long identificationNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "date_start_job")
    private Date dateStartJob;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "zalo")
    private String zalo;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "party_member")
    private boolean partyMember;
    @Column(name = "number_of_years_of_experience")
    private int numberOfYearsOfExperience;
    @Column(name = "gratuated_from")
    private String gratuatedFrom;
    @Column(name = "password",length = 100)
    private String password;
    @OneToOne(mappedBy = "staffDetail", cascade = CascadeType.ALL)
    private Staff staff;

}
