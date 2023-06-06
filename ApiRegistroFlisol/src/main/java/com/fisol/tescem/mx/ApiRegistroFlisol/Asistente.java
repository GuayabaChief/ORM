package com.fisol.tescem.mx.ApiRegistroFlisol;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Asistente")
public class Asistente implements Serializable{
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAsistente;
	
	@NotBlank(message = "El nombre del asistente es obligatorio")
	@Size(min = 4, max  = 45, message="El tamaño tiene que estar entre 4 y 45")
	@Column(name = "nombreAsistente", length = 45, nullable=false)
	private String nombreAsistente;
	
	@NotBlank(message = "El apellido paterno del asistente es obligatorio")
	@Size(min = 4, max = 45, message="El tamaño tiene que estar entre 4 y 45")
	@Column(name ="paternoAsistente", length = 45, nullable =false)
	private String paternoAsistente;
	
	@NotBlank(message = "El apellido materno del asistente es obligatorio")
	@Size(min = 4, max = 45, message="El tamaño tiene que estar entre 4 y 45")
	@Column(name ="maternoAsistente", length = 45, nullable =false)
	private String maternoAsistente;
	
	@NotBlank(message = "El correo electronico es obligatorio")
	@Size(min=4, max=45, message="El tamaño tiene que estar entre 4 y 45")
	@Column(name="emailAsistente", length = 45, nullable =false)
	@Email(message="El correo electronico debe ser valido")
	private String emailAsistente;
	
	@JsonIgnoreProperties(value= {"listaAsistentes", "hibernateLazyInitializer", "handler"},
			allowSetters=true)
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "idEvento", referencedColumnName = "idEvento")
	private Evento evento;
}
