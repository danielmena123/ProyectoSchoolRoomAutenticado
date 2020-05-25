package com.proyecto.schoolroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entity.inscripcionMateria;
import com.proyecto.schoolroom.repository.inscripcionMateriaRepository;


@RestController
@RequestMapping("/inscripcionMaterias")
@CrossOrigin(origins = "*")
public class inscripcionMateriaRestController {

    @Autowired
    private inscripcionMateriaRepository inscripcionMateriaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public List<inscripcionMateria> findAll() {
        return inscripcionMateriaRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{inscripcionMateriaId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public inscripcionMateria findOne(@PathVariable Long inscripcionMateriaId) {
        return inscripcionMateriaRepository.findOne(inscripcionMateriaId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public inscripcionMateria add(@RequestBody inscripcionMateria inscripcionMateria) {
        return inscripcionMateriaRepository.save(inscripcionMateria);
    }

	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public inscripcionMateria update(@RequestBody inscripcionMateria inscripcionMateria) {
        return inscripcionMateriaRepository.save(inscripcionMateria);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{inscripcionMateriaId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public void delete(@PathVariable Long inscripcionMateriaId) {
        inscripcionMateriaRepository.delete(inscripcionMateriaId);
    }
	
}

