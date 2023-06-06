package com.fisol.tescem.mx.ApiRegistroFlisol;

import com.fisol.tescem.mx.ApiRegistroFlisol.EventoDAO;
import com.fisol.tescem.mx.ApiRegistroFlisol.Evento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/apiEventos")
public class EventoController {
	@Autowired
	private EventoService service;
	@GetMapping("/eventos")
	public List<Evento> readAll(){
		return service.readAll();
	}
	@GetMapping("/eventos/{id}")
	public Evento read(@PathVariable Long id) {
		return service.read(id);
	}
	@DeleteMapping("/eventos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	@PostMapping("/eventos")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento save (@RequestBody Evento evento) {
		return service.create(evento);
	}
	@PutMapping("/eventos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento update(@RequestBody Evento evento, @PathVariable Long id) {
		Evento e =service.read(id);
		e.setNombreEvento(evento.getNombreEvento());
		e.setDescripcionEvento(evento.getDescripcionEvento());
		e.setFechaEvento(evento.getFechaEvento());
		return service.create(e);
	}
}
