package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "register_Notebook")
@Data
public class RegisterNotebook {
    @Id
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "class_name")
    private SchoolClass schoolClassName;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(name = "teaching_day")
    private Date teachingDay;

    @Column(name = "lecture_content")
    private String lectureContent;
}
