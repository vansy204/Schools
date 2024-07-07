package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "school_record")
@Data
public class SchoolRecord {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Transcript_student_id")
    private Transcript transcript;

    @Column(name = "conduct")
    private String conduct;
    @Column(name = "teacher_comment")
    private String teacherComment;
    @Column(name = "parent's_comment")
    private String parentsComment;
}
