package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne( cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "class_name")
    private SchoolClass studentSchoolClass;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "average_score")
    private double averageScore;
    @Column(name = "class_rank")
    private int classRank;
    @ManyToOne(
            cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
        })
    @JoinColumn(name = "class_name",insertable = false, updatable = false)
    private SchoolClass schoolClassName;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private School school;
}
