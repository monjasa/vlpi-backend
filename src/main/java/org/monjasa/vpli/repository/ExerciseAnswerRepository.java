package org.monjasa.vpli.repository;

import org.monjasa.vpli.domain.ExerciseAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseAnswerRepository extends JpaRepository<ExerciseAnswer, Long> {
}
