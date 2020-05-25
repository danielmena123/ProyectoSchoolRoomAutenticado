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
@Table(name = "Grados")
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_GRADO", nullable = false, length = 50)
	private String grado;
	
	@Column(name = "SECCION", nullable = false, length = 2)
	private String seccion;
	
	@Column(name = "CODIGO_GRADO", nullable = false, length = 30)
	private String codigo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<inscripcionEncargado> inscripcionE;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<inscripcionMateria> inscripcionM;
	//Constructores
	
	public Grado() {}

	public Grado(Long id, String grado, String seccion, String codigo) {
		this.id = id;
		this.grado = grado;
		this.seccion = seccion;
		this.codigo = codigo;
	}
	
	public Grado(String grado, String seccion, String codigo) {
		this.grado = grado;
		this.seccion = seccion;
		this.codigo = codigo;
	}
	
	//Metodos
	
	public void addInscripcion(inscripcionEncargado i) {
		if (!inscripcionE.contains(i)) {
			inscripcionE.add(i);
			i.setGrado(this);
		}
	}
	
	public void deleteInscripcion(inscripcionEncargado i) {
		if (inscripcionE.contains(i)) {
			inscripcionE.remove(i);
			i.setGrado(null);
		}	
	}
	
	public void addInscripcion(inscripcionMateria i) {
		if (!inscripcionM.contains(i)) {
			inscripcionM.add(i);
			i.setGrado(this);
		}
	}
	
	public void deleteInscripcion(inscripcionMateria i) {
		if (inscripcionM.contains(i)) {
			inscripcionM.remove(i);
			i.setGrado(null);
		}	
	}
	
	//Getters && Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String num_grado) {
		this.grado = num_grado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
