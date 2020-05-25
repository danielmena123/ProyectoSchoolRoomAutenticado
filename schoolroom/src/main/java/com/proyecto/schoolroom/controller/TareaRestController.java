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

import com.proyecto.schoolroom.entity.Tarea;
import com.proyecto.schoolroom.repository.TareaRepository;


@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "*")
public class TareaRestController {

    @Autowired
    private TareaRepository tareaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{tareaId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public Tarea findOne(@PathVariable Long tareaId) {
        return tareaRepository.findOne(tareaId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public Tarea add(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public Tarea update(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{tareaId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')")
    public void delete(@PathVariable Long tareaId) {
        tareaRepository.delete(tareaId);
    }
	
}

