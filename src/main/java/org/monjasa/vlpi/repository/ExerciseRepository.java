package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    
    List<Exercise> findAllByModuleId(Long moduleId);

}
