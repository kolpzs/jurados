package com.jurados.repositories;

import com.jurados.entities.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
}
