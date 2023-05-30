package com.ksotelo.web.waterbnb.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comentarios")
public class ComentarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="debe ingresar un comentario")
	@Size(min = 3, max = 30, message = "comentario debe contener entre 3 y 30 caracteres")
	private String comentario;
	
	@Min(value=1, message="debe seleccionar un rating")
	private int rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserModel autor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "piscina_id")
	private PiscinaModel piscina;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public UserModel getAutor() {
		return autor;
	}

	public void setAutor(UserModel autor) {
		this.autor = autor;
	}

	public PiscinaModel getPiscina() {
		return piscina;
	}

	public void setPiscina(PiscinaModel piscina) {
		this.piscina = piscina;
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

	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ComentarioModel() {
	}

	public ComentarioModel(String comentario, UserModel autor, int rating, PiscinaModel piscina) {
		this.comentario = comentario;
		this.autor = autor;
		this.piscina = piscina;
		this.rating = rating;
	}
}
