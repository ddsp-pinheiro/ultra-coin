package com.ultracoin.repository;

import com.ultracoin.entity.TransitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransitionEntity, Long> {
    Optional<TransitionEntity> findById(Long id);
}
