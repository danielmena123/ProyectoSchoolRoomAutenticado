package com.proyecto.schoolroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.schoolroom.entity.inscripcionEncargado;

public interface inscripcionEncargadoRepository extends JpaRepository<inscripcionEncargado, Long> {
    //User findByUsername(String username);
}
