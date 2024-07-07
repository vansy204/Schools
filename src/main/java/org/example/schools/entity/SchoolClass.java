package org.example.schools.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @Column(name = "class_name")
    private String className;
    @Column(name = "rank")
    private int rank;
    @Column(name = "block")
    private int block;
    @Column(name = "school_year")
    private String schoolYear;
    @Column(name = "homeroom_teacher_id")
    private Long homeroomTeacherId;
    @Column(name = "homeroom_teacher_name")
    private String homeroomTeacherName;
    @Column(name = "number_of_class")
    private int numberOfClass;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "school")
    private School school;
    @OneToMany(
            cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
            },
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "student_id")
    private List<Student> students;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            },
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "teacher_id")
    private List<Staff> teachers;

    public Class() {
    }

    public Class(String className, int rank, int block, String schoolYear, Long homeroomTeacherId, String homeroomTeacherName, int numberOfClass, School school) {
        this.className = className;
        this.rank = rank;
        this.block = block;
        this.schoolYear = schoolYear;
        this.homeroomTeacherId = homeroomTeacherId;
        this.homeroomTeacherName = homeroomTeacherName;
        this.numberOfClass = numberOfClass;
        this.school = school;
    }

    public Class(String className, int rank, int block, String schoolYear, Long homeroomTeacherId, String homeroomTeacherName, int numberOfClass, School school, List<Student> students, List<Staff> teachers) {
        this.className = className;
        this.rank = rank;
        this.block = block;
        this.schoolYear = schoolYear;
        this.homeroomTeacherId = homeroomTeacherId;
        this.homeroomTeacherName = homeroomTeacherName;
        this.numberOfClass = numberOfClass;
        this.school = school;
        this.students = students;
        this.teachers = teachers;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Long getHomeroomTeacherId() {
        return homeroomTeacherId;
    }

    public void setHomeroomTeacherId(Long homeroomTeacherId) {
        this.homeroomTeacherId = homeroomTeacherId;
    }

    public String getHomeroomTeacherName() {
        return homeroomTeacherName;
    }

    public void setHomeroomTeacherName(String homeroomTeacherName) {
        this.homeroomTeacherName = homeroomTeacherName;
    }

    public int getNumberOfClass() {
        return numberOfClass;
    }

    public void setNumberOfClass(int numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Staff> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Staff> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Class{" +
                "className='" + className + '\'' +
                ", rank=" + rank +
                ", block=" + block +
                ", schoolYear='" + schoolYear + '\'' +
                ", homeroomTeacherId=" + homeroomTeacherId +
                ", homeroomTeacherName='" + homeroomTeacherName + '\'' +
                ", numberOfClass=" + numberOfClass +
                ", school=" + school +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
