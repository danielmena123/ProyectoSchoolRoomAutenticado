package com.proyecto.schoolroom.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyecto.schoolroom.security.model.User;


@Entity
@Table(name = "Inscripcion_Materias")
public class inscripcionMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA_INSCRIPCION", nullable = false, length = 20)
	private Date fecha_inscripcion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	@JsonBackReference("usuario")
		private User usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GRADO")
	@JsonBackReference("grado")
		private Grado grado;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MATERIA")
	@JsonBackReference("materia")
			private Materia materia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "inscripcion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Tarea> tarea;
		
	//Constructores
	
	public inscripcionMateria() {}

	public inscripcionMateria(Long id, Date fecha_inscripcion, User usuario, Grado grado, Materia materia) {
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.usuario = usuario;
		this.grado = grado;
		this.materia = materia;
	}
	
	public inscripcionMateria(Date fecha_inscripcion, User usuario, Grado grado, Materia materia) {
		this.fecha_inscripcion = fecha_inscripcion;
		this.usuario = usuario;
		this.grado = grado;
		this.materia = materia;
	}
	
	//Metodos

	@JsonProperty("usuario")
	private void addDocente(Long id) {
	    this.usuario = new User();
	    usuario.setId(id);
	}
	
	@JsonProperty("grado")
	private void addGrado(Long id) {
	    this.grado = new Grado();
	    grado.setId(id);
	}
	
	@JsonProperty("materia")
	private void addMateria(Long id) {
	    this.materia = new Materia();
	    materia.setId(id);
	}
	
	public void addInscripcion(Tarea i) {
		if (!tarea.contains(i)) {
			tarea.add(i);
			i.setInscripcion(this);
		}
	}
	
	public void deleteInscripcion(Tarea i) {
		if (tarea.contains(i)) {
			tarea.remove(i);
			i.setInscripcion(null);
		}	
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
