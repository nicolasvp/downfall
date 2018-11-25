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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rol rol;
	
	@NotNull
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date createdAt;
}
