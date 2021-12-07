package org.monjasa.vlpi.repository;

import org.monjasa.vlpi.domain.UserAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByEmail(String email);

    @EntityGraph(attributePaths = "roles")
    Optional<UserAccount> findFetchingRolesByEmail(String email);

    boolean existsByEmail(String email);

}
