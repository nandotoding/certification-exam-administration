package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.ScoreReport;
import com.test.certificationexamadministration.model.request.ScoreRequest;

import java.util.List;

public interface ScoreService {

    Score add(ScoreRequest scoreRequest);
    List<Score> getAll();
    List<ScoreReport> getScoreReport();

}
