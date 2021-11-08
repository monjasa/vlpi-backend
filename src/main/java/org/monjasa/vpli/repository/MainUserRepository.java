package org.monjasa.vpli.repository;

import org.monjasa.vpli.domain.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {
}
