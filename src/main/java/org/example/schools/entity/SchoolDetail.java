package org.example.schools.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Entity
@Table(name = "school_detail")
@Data
public class SchoolDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "abbreviations",length = 255,nullable = false)
    private String abbreviations;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "zalo")
    private String zalo;
    @Column(name = "confession")
    private String confession;
    @Lob
    @Column(name = "Logo")
    private Blob Logo;
    
}
