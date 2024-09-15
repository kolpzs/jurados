package com.jurados.repositories;

import com.jurados.entities.AvaliadorEntity;
import com.jurados.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
