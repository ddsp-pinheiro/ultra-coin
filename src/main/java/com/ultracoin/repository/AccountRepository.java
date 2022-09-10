package com.ultracoin.repository;

import com.ultracoin.entity.AccountEntity;
import com.ultracoin.entity.TransitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findById(Long id);
    Optional<AccountEntity> findByAccountNumber(int accountNumber);
}
