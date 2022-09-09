package com.ultracoin.repository;

import com.ultracoin.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findById(Long id);
    Optional<AddressEntity> findByIdPerson(Long id);
}
