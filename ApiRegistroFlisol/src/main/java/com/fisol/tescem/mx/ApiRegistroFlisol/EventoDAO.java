package com.fisol.tescem.mx.ApiRegistroFlisol;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fisol.tescem.mx.ApiRegistroFlisol.Evento;

public interface EventoDAO extends JpaRepository<Evento, Long>{
	
}
