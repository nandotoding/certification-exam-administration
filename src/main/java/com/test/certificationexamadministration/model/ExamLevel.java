package com.test.certificationexamadministration.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exam_levels")
public class ExamLevel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "level_id")
    private String levelId;

    @Column(name = "level_code")
    private String levelCode;

    @Column(name = "level_name")
    private String levelName;

}
