package com.test.certificationexamadministration.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "exam_attempts")
public class ExamAttempt {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "attempt_id")
    private String attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "module_id")
    private ExamModule examModule;

    @Column(name = "attempt_date")
    private Date attemptDate;

}
