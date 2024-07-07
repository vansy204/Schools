package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "transcipt")
@Data
public class Transcript {
    @Id
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "class_name")
    private SchoolClass schoolClassName;
    @OneToMany(mappedBy = "transcript", cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
    private List<Subject> subjects;
    @Column(name = "semester")
    private String semester;
    @Column(name = "score")
    private double score;
    @OneToMany(mappedBy = "transcript")
    private List<SchoolRecord> schoolRecords;
}
