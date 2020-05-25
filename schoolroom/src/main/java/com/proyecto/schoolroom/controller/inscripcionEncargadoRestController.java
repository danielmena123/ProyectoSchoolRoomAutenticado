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

import com.proyecto.schoolroom.entity.inscripcionEncargado;
import com.proyecto.schoolroom.repository.inscripcionEncargadoRepository;


@RestController
@RequestMapping("/inscripcionEncargados")
@CrossOrigin(origins = "*")
public class inscripcionEncargadoRestController {

    @Autowired
    private inscripcionEncargadoRepository inscripcionEncargadoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public List<inscripcionEncargado> findAll() {
        return inscripcionEncargadoRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{inscripcionEncargadoId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public inscripcionEncargado findOne(@PathVariable Long inscripcionEncargadoId) {
        return inscripcionEncargadoRepository.findOne(inscripcionEncargadoId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public inscripcionEncargado add(@RequestBody inscripcionEncargado inscripcionEncargado) {
        return inscripcionEncargadoRepository.save(inscripcionEncargado);
    }

	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public inscripcionEncargado update(@RequestBody inscripcionEncargado inscripcionEncargado) {
        return inscripcionEncargadoRepository.save(inscripcionEncargado);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{inscripcionEncargadoId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public void delete(@PathVariable Long inscripcionEncargadoId) {
        inscripcionEncargadoRepository.delete(inscripcionEncargadoId);
    }
	
}

