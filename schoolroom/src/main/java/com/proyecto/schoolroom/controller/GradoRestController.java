package com.proyecto.schoolroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.entity.Grado;
import com.proyecto.schoolroom.repository.GradoRepository;
import com.proyecto.schoolroom.utils.GeneradorAleatorio;


@RestController
@RequestMapping("/grados")
@CrossOrigin(origins = "*")
public class GradoRestController {

    @Autowired
    private GradoRepository gradoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public List<Grado> findAll() {
        return gradoRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{gradoId}")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
    public Grado findOne(@PathVariable Long gradoId) {
        return gradoRepository.findOne(gradoId);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/grado")
	@PreAuthorize("hasRole('ADMIN')" + " || hasRole('DOCENTE')" + " || hasRole('ENCARGADO')")
	public Grado findByCodigo(@RequestParam String codigo){
		return gradoRepository.findByCodigo(codigo);
	}
    
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
    public Grado add(@RequestBody Grado grado) {
        return gradoRepository.save(grado);
    }

	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
    public Grado update(@RequestBody Grado grado) {
        return gradoRepository.save(grado);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{gradoId}")
	@PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long gradoId){
        gradoRepository.delete(gradoId);
    }
	
	//Generar Codigo
	@RequestMapping(value = "/codigo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String generarCodigo() {
		GeneradorAleatorio g = new GeneradorAleatorio();
		return g.Aleatorio();
	}
		
	//Generar Correo
	@RequestMapping(value = "/correo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String generarCorreo(@RequestParam(value = "nombres")String nombres, @RequestParam(value = "apellidos")String apellidos, @RequestParam(value = "feacha")String fecha){
		GeneradorAleatorio g = new GeneradorAleatorio();
		return g.Correo(nombres, apellidos, fecha);
	}
	
}

