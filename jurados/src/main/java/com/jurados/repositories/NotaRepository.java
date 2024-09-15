package com.jurados.repositories;

import com.jurados.entities.AdmEntity;
import com.jurados.entities.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
}
