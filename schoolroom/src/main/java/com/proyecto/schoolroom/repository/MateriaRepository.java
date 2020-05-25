package com.proyecto.schoolroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.schoolroom.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
    //User findByUsername(String username);
}
