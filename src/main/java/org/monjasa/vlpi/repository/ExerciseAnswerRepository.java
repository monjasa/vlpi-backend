package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseAnswerRepository extends JpaRepository<ExerciseAnswer, Long> {
}
