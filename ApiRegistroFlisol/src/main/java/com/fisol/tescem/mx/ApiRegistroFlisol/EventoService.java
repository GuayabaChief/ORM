package com.fisol.tescem.mx.ApiRegistroFlisol;

import java.util.List;
import com.fisol.tescem.mx.ApiRegistroFlisol.Evento;

public class EventoService {
	public List<Evento> readAll();
	
	public Evento create(Evento evento);
	
	public Evento read(Long id);
	
	public void delete(Long id);
}
