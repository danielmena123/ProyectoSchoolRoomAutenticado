package com.proyecto.schoolroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.schoolroom.entity.Grado;

public interface GradoRepository extends JpaRepository<Grado, Long> {
    //User findByUsername(String username);
	public Grado findByCodigo(String codigo);
	
	@Query(value = "select seccion from grados where grado = ?1", nativeQuery = true)
	public List<String> findByGrado(String grado);
	
}
