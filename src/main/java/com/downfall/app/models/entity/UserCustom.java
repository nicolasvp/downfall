package com.downfall.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

/*
 * Usé UserCustom en vez de User ya que en Spring Security ya existe la clase User y causaba problemas en el service
 */

@Entity
@Table(name="users")
public class UserCustom implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=30)
	@NotEmpty(message="no puede estar vacío")
	private String name;
	
	@Column(unique=true, length=20)
	private String username;
	
	@Column(unique=true, length=20)
	private String email;
	
	@Column(length=60)
	private String password;
	
	private Boolean enabled;
	
	// Al crear una relacion ManyToMany se crea una tabla intermedia automaticamente
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	// JoinTable se utiliza cuando se quiere personalizar la tabla que se crea cuando existe la relación ManyToMany, se le indica el nombre de la tabla y los nombres de las columnas que tendra
	// Se utiliza uniqueConstraints para decir que el usuario no se le puede repetir el mismo rol
	@JoinTable(name="users_roles", 
	joinColumns=@JoinColumn(name="user_id"), 
	inverseJoinColumns=@JoinColumn(name="role_id"), 
	uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})}
	)
	private List<Role> roles;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
