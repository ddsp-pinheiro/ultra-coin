package com.ultracoin.repository;

import com.ultracoin.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findById(Long id);
    Optional<PersonEntity> findByEmail(String email);
    Optional<PersonEntity> findByTaxId(String taxId);
}
