package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.request.ScoreRequest;

public interface ScoreService {

    Score add(ScoreRequest scoreRequest);

}
