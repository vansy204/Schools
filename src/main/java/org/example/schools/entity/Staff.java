package org.example.schools.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name",length = 255)
    private String firstName;
    @Column(name = "last_name",length = 255)
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "role",nullable = false)
    private String role;
    @Column(name = "email")
    private String email;
    @Column(name = "number_of_subjects_taught")
    private int numberOfSubjectsTaught;
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        },
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    @JoinColumn(name = "class_name_leader")
    private SchoolClass classLeader;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_detail_id")
    private StaffDetail staffDetail;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private School school;
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    private List<RegisterNotebook> registerNotebooks;

}
