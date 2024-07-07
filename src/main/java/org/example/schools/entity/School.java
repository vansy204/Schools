package org.example.schools.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "school")
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",length = 255)
    private String name;
    @Column(name = "address",length = 255)
    private String address;
    @Column(name = "phone",length = 15)
    private String phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shool_detail_id")
    private SchoolDetail schoolDetail;
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<SchoolClass> schoolClasses;
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Staff> staffs;
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Student> students;


}
