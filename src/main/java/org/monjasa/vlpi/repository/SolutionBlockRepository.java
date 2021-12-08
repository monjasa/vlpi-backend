package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.SolutionBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionBlockRepository extends JpaRepository<SolutionBlock, Long> {

    @Query("select solutionBlock from SolutionBlock solutionBlock " +
            "where solutionBlock.task.id = :taskId and solutionBlock.solutionOrder is not null " +
            "order by solutionBlock.solutionOrder")
    List<SolutionBlock> findAllForSolutionByTaskId(Long taskId);

}
