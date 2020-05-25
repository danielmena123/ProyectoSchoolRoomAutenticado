package com.proyecto.schoolroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.schoolroom.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    //User findByUsername(String username);
}
