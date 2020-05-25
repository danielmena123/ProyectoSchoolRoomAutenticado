package com.proyecto.schoolroom.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE_MATERIA", nullable = false, length = 60)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<inscripcionMateria> inscripcionM;
	
	//Constructores
	
	public Materia() {};

	public Materia(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Materia(String nombre) {
		this.nombre = nombre;
	}
	
	//Metodos
	
	public void addInscripcion(inscripcionMateria i) {
		if (!inscripcionM.contains(i)) {
			inscripcionM.add(i);
			i.setMateria(this);
		}
	}
	
	public void deleteInscripcion(inscripcionMateria i) {
		if (inscripcionM.contains(i)) {
			inscripcionM.remove(i);
			i.setMateria(null);
		}	
	}
	
	//Getters && Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
