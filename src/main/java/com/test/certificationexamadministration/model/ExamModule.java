package com.test.certificationexamadministration.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exam_modules")
public class ExamModule {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "module_id")
    private String moduleId;

    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "module_name")
    private String moduleName;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "level_id")
    private ExamLevel examLevel;

}
