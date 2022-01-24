package com.huyeon.online.paper.repository;

import com.huyeon.online.paper.domain.PaperAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperAnswerRepository extends JpaRepository<PaperAnswer, PaperAnswer.PaperAnswerId> {

}
