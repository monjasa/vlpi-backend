package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.TaskAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAnswerRepository extends JpaRepository<TaskAnswer, Long> {
}
