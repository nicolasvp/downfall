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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="artists")
public class Artist implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	
	
	@NotNull
	@Column(name="born_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date bornDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	

	@ManyToOne(fetch = FetchType.LAZY)
	private Genre genre;
	
	private String photo;
	
	// Con mappedBy crea la fk en albums con el nombre artist_id(esta relacion es bidireccional)
	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Album> albums;
	
	// Con mappedBy crea la fk en albums con el nombre artist_id(esta relacion es bidireccional)
	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Demo> demos;
	
	@NotNull
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date createdAt;
	
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Demo> getDemos() {
		return demos;
	}

	public void setDemos(List<Demo> demos) {
		this.demos = demos;
	}
}
