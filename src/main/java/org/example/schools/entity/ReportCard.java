package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;


@Entity
@Table(name = "report_Card")
@Data
public class ReportCard {
    @Id
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    private Student student;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    private Subject subject;
    @Column(name = "oral_test")
    private double oralTest;
    @Column(name = "Date_oral_test")
    private Date dateOralTest;
    @Column(name = "homework_score")
    private double homeworkScore;
    @Column(name = "Date_Homework_exam")
    private Date dateHomeworkExam;
    @Column(name = "15_minutes_test")
    private double minutes15Test;
    @Column(name = "Date_15minutes_exam")
    private Date date15minutesExam;
    @Column(name = "mid-term_test")
    private double midTermTest;
    @Column(name = "Date_mid-term_exam")
    private Date dateMidTermExam;
    @Column(name = "final_exam")
    private double finalExam;
    @Column(name = "Date_final_exam")
    private Date dateFinalExam;
}
