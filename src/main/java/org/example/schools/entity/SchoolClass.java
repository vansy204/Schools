package org.example.schools.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "School_class")
@Data
public class SchoolClass {
    @Id
    @Column(name = "class_name")
    private String className;
    @Column(name = "class_rank")
    private int classRank;
    @Column(name = "block")
    private int block;
    @Column(name = "school_year")
    private String schoolYear;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
        },
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    @JoinColumn(name = "home_room_teacher")
    private Staff homeRoomTeacher;

    @Column(name = "number_of_class")
    private int numberOfClass;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "school")
    private School school;



}
