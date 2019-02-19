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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="albums")
public class Album implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="no puede estar vacío")
	@Size(min=1, max=100, message="debe tener entre 1 y 100 caracteres")
	private String name;
	
	@Column(nullable = true)
	private String image;
	
	// NotNull para cuando es un objeto, NotEmpty para cuando es  un String
	@Column(name="release_date")
	@NotNull(message="no puede estar vacío")
	private Date releaseDate;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	// JsonIgnoreProperties para eliminar los atributos que no sirven ("hibernateLazyInitializer", "handler"), ademas evitar que la relación caiga en un loop infinito (padre pide los hijos y los hijos al padre y asi sucesivamente)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "albums"})
	@NotNull(message="no puede estar vacío")
	@ManyToOne(fetch=FetchType.LAZY)
	private Artist artist;
	
	// JsonIgnoreProperties para eliminar los atributos que no sirven ("hibernateLazyInitializer", "handler"), ademas evitar que la relación caiga en un loop infinito (padre pide los hijos y los hijos al padre y asi sucesivamente)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "album"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="album", cascade=CascadeType.ALL)
	private List<Track> tracks;
	
	// Crea la fecha actual para el campo createdAt
	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}
	
	public Album() {
		this.tracks = new ArrayList<Track>();
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


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
