package com.downfall.app.models.entity;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Debe escribir un nombre para el Artista")
	@Column(nullable = false, unique=true)
	@Size(min=1, max=100, message="El tamaño debe ser entre 1 y 20 caracteres")
	private String name;
	
	@Column(nullable = true)
	private String image;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	// JsonIgnoreProperties para eliminar los atributos que no sirven ("hibernateLazyInitializer", "handler"), ademas evitar que la relación caiga en un loop infinito (padre pide los hijos y los hijos al padre y asi sucesivamente)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "artists"})
	// Muchos artistas pertenecen a un solo genero, se incluye el join column para especificar el campo que será la llave foranea
	@ManyToOne(fetch=FetchType.LAZY)
	private Genre genre;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "artist"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="artist", cascade=CascadeType.ALL)
	private List<Album> albums;
	
	// Crea la fecha actual para el campo createdAt
	public void prePersist() {
		this.createdAt = new Date();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
