package com.downfall.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tracks")
public class Track implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="no puede estar vacío")
	@Size(min=1, max=100, message="debe tener entre 1 y 100 caracteres")
	private String name;
	
	@NotNull(message="no puede estar vacío")
	@Min(1)
	@Max(999)
	private Integer duration;
	
	@Column(name="track_number")
	@NotNull(message="no puede estar vacío")
	@Min(1)
	@Max(999)
	private Integer trackNumber;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	// JsonIgnoreProperties para eliminar los atributos que no sirven ("hibernateLazyInitializer", "handler"), ademas evitar que la relación caiga en un loop infinito (padre pide los hijos y los hijos al padre y asi sucesivamente)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tracks"})
	@NotNull(message="no puede estar vacío")
	@ManyToOne(fetch=FetchType.LAZY)
	private Album album;
	
	// Crea la fecha actual para el campo createdAt
	@PrePersist
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
