package com.jurados.repositories;

import com.jurados.entities.AdmEntity;
import com.jurados.entities.IdeiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeiaRepository extends JpaRepository<IdeiaEntity, Long> {
}
