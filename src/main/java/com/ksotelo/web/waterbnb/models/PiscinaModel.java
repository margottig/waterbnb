package com.ksotelo.web.waterbnb.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "piscinas")
public class PiscinaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "dirección no puede estar vacío")
	@Size(min = 3, message = "la dirección debe tener mínimo 3 carácteres")
	private String address;

	@NotBlank(message = "seleccione un tamaño")
	private String poolSize;

	@Min(value = 1, message = "debe ingresar un costo por noche")
	private double cost;

	@DecimalMin("1.0")
	@DecimalMax("5.0")
	private Double rating = 1.0;

	@NotBlank(message = "la descipción no puede estar vacía")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserModel owner;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToMany(mappedBy = "piscina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ComentarioModel> comentarios;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public UserModel getOwner() {
		return owner;
	}

	public void setOwner(UserModel owner) {
		this.owner = owner;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ComentarioModel> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioModel> comentarios) {
		this.comentarios = comentarios;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public PiscinaModel() {
	}

	public PiscinaModel(String address, String poolSize, Double cost, String description, UserModel owner) {
		this.address = address;
		this.poolSize = poolSize;
		this.cost = cost;
		this.description = description;
		this.owner = owner;
	}

}
