package org.monjasa.vpli.repository;

import org.monjasa.vpli.domain.TaskAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAnswerRepository extends JpaRepository<TaskAnswer, Long> {
}
