package com.copeuch.fullstackbackend.repository;

import com.copeuch.fullstackbackend.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea,Long> {
}
