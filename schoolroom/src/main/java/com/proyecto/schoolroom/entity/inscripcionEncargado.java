package com.proyecto.schoolroom.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyecto.schoolroom.security.model.User;


@Entity
@Table(name = "Inscripcion_Encargados")
public class inscripcionEncargado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "FECHA_INSCRIPCION", nullable = false, length = 20)
	private Date fecha_inscripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	@JsonBackReference("usuario")
		private User usuario;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRADO")
	@JsonBackReference("grado")
		private Grado grado;
	
	//Constructores
	
	public inscripcionEncargado() {}

	public inscripcionEncargado(Long id, Date fecha_inscripcion, User usuario, Grado grado) {
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.usuario = usuario;
		this.grado = grado;
	}
	
	public inscripcionEncargado(Date fecha_inscripcion, User usuario, Grado grado) {
		this.fecha_inscripcion = fecha_inscripcion;
		this.usuario = usuario;
		this.grado = grado;
	}
	
	//Metodos
	
	@JsonProperty("encargado")
	private void addUsuario(Long id) {
	    this.usuario = new User();
	    usuario.setId(id);
	}
	
	@JsonProperty("grado")
	private void addGrado(Long id) {
	    this.grado = new Grado();
	    grado.setId(id);
	}
	
	//Getters && Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

}
