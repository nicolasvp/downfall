package com.downfall.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	@NotEmpty(message="Debe escribir un nombre para el genero")
	@Size(min=1, max=100, message="El tamaño debe ser entre 1 y 20 caracteres")
	private String name;

	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	// JsonIgnoreProperties para eliminar los atributos que no sirven ("hibernateLazyInitializer", "handler"), ademas evitar que la relación caiga en un loop infinito (padre pide los hijos y los hijos al padre y asi sucesivamente)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "genre"})
	// Un genero tiene muchos artistas, se escribe el mapped by con el nombre de referencia de esta entidad en la entidad hija, padre(genre), hija(artist)
	@OneToMany(fetch=FetchType.LAZY, mappedBy="genre", cascade=CascadeType.ALL)
	// Se incluye el join column para especificar el campo que será la llave foranea, si no se incluye el join se puede hacer atraves del mappedBy
	//@JoinColumn(name="genre_id")
	private List<Artist> artists;
	
	// Inicializa el arraylist de artistas
	public Genre() {
		this.artists = new ArrayList<>();
	}

	// Crea la fecha actual para el campo createdAt
	public void prePersist() {
		createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
}
