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


@Entity
@Table(name = "Tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA_ASIGNADA", nullable = false, length = 20)
	private Date fecha_asignada;
	
	@Column(name = "FECHA_ENTREGA", nullable = false, length = 20)
	private Date fecha_entrega;
	
	@Column(name = "DESCRIPCION_TAREA", nullable = false, length = 900)
	private String descripcion;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_INSCRIPCION")
	@JsonBackReference("inscripcion")
		private inscripcionMateria inscripcion;
	
	//Constructores
	
	public Tarea() {}

	public Tarea(Long id, Date fecha_asignada, Date fecha_entrega, String descripcion, inscripcionMateria inscripcion) {
		this.id = id;
		this.fecha_asignada = fecha_asignada;
		this.fecha_entrega = fecha_entrega;
		this.descripcion = descripcion;
		this.inscripcion = inscripcion;
	}

	public Tarea(Date fecha_asignada, Date fecha_entrega, String descripcion, inscripcionMateria inscripcion) {
		this.fecha_asignada = fecha_asignada;
		this.fecha_entrega = fecha_entrega;
		this.descripcion = descripcion;
		this.inscripcion = inscripcion;
	}

	//Metodores
	
	@JsonProperty("inscripcion")
	private void addInscripcion(Long id) {
	    this.inscripcion = new inscripcionMateria();
	    inscripcion.setId(id);
	}
	
	//Getters && Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_asignada() {
		return fecha_asignada;
	}

	public void setFecha_asignada(Date fecha_asignada) {
		this.fecha_asignada = fecha_asignada;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public inscripcionMateria getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(inscripcionMateria inscripcion) {
		this.inscripcion = inscripcion;
	}

}
