package com.test.certificationexamadministration.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "score_id")
    private String scoreId;

    @OneToOne
    @JoinColumn(name = "attempt_id", referencedColumnName = "attempt_id")
    private ExamAttempt examAttempt;

    private Double score;

}
