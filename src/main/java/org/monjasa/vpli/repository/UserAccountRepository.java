package org.monjasa.vpli.repository;

import org.monjasa.vpli.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query("select userAccount from UserAccount userAccount " +
            "join fetch userAccount.roles roles " +
            "where userAccount.email = :email")
    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);

}
