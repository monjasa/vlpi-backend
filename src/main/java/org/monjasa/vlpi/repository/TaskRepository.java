package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph(attributePaths = "solutionBlocks")
    List<Task> findFetchingSolutionBlocksByExerciseId(Long exerciseId);

}
