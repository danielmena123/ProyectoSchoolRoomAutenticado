package com.proyecto.schoolroom.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.schoolroom.security.model.User;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminRestController {


    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "This resource is protected";
    }
    
    @RequestMapping(value = "/docentes", method = RequestMethod.GET)
    public User listaDocentes() {
    	
    	return null;
    }
    
    @RequestMapping(value = "/encargados", method = RequestMethod.GET)
    public User listaEncargados() {
    	
    	return null;
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public User nuevoUsuario() {
    	
    	return null;
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public User actualizarUsuario() {
    	return null;
    }
    
    @RequestMapping
    public User eliminarUsuario() {
    	return null;
    }
}

