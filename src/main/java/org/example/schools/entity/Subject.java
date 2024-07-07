package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subject")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_subject")
    private String name;
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "teacher_id")
    private Staff teacher;
    @ManyToOne
    @JoinColumn(name = "transcipt")
    private Transcript transcript;
    

}
