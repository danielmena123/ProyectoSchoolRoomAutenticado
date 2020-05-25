package com.proyecto.schoolroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.schoolroom.entity.inscripcionMateria;

public interface inscripcionMateriaRepository extends JpaRepository<inscripcionMateria, Long> {
    //User findByUsername(String username);
}
