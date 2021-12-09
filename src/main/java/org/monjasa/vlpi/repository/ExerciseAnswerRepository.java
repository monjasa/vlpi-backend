package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseAnswerRepository extends JpaRepository<ExerciseAnswer, Long> {

    @EntityGraph(attributePaths = "taskAnswers")
    List<ExerciseAnswer> findAllFetchingTaskAnswersByUserAccountId(Long userAccountId);

}
