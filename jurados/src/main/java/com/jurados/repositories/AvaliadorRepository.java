package com.jurados.repositories;

import com.jurados.entities.AvaliadorEntity;
import com.jurados.entities.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliadorRepository extends JpaRepository<AvaliadorEntity, Long> {
}
