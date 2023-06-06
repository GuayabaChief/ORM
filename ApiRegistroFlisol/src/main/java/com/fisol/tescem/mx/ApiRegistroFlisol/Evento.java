package com.fisol.tescem.mx.ApiRegistroFlisol;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.Cascade;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Evento")
public class Evento implements Serializable{
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvento;
	
	@NotBlank(message= "La descripcion del evento es obligatorio")
	@Size(min = 4, max = 100, message="El tamaño debe estar entre 4 y 100")
	@Column(name="descripcionEvento", length = 200, nullable = false)
	private String descripcionEvento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaEvento")
	private Date fechaEvento;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval =true)
	@JoinColumn(name="idEvento")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<Asistente> listaAsistentes;
}
