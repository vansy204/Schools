package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "parent")
@Data
public class Parents {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "father_date_of_birth")
    private Date fatherDateOfBirth;
    @Column(name = "father_phone")
    private Long fatherPhone;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "mother_date_of_birth")
    private Date motherDateOfBirth;
    @Column(name = "mother_phone")
    private Long motherPhone;
    @Column(name = "address")
    private String address;
}
