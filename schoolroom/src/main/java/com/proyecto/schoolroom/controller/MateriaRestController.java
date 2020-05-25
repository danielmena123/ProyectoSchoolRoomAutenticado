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

import com.proyecto.schoolroom.entity.Materia;
import com.proyecto.schoolroom.repository.MateriaRepository;


@RestController
@RequestMapping("/materias")
@CrossOrigin(origins = "*")
public class MateriaRestController {

    @Autowired
    private MateriaRepository materiaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{materiaId}" + " || hasRole('ENCARGADO')")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public Materia findOne(@PathVariable Long materiaId) {
        return materiaRepository.findOne(materiaId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
    public Materia add(@RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }

	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
    public Materia update(@RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{materiaId}")
	@PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long materiaId) {
        materiaRepository.delete(materiaId);
    }
	
}

