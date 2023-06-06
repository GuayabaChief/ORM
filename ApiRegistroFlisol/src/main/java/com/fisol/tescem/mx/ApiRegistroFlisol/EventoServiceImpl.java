package com.fisol.tescem.mx.ApiRegistroFlisol;

import com.fisol.tescem.mx.ApiRegistroFlisol.EventoDAO;
import com.fisol.tescem.mx.ApiRegistroFlisol.Evento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class EventoServiceImpl implements EventoService{
	@Autowired
	private EventoDAO daoEvento;
	@Override
	@Transactional(readOnly=true)
	public List<Evento> readAll(){
		return daoEvento.findAll();
	}
	@Override
	@Transactional
	public Evento create(Evento evento) {
		return daoEvento.save(evento);
	}
	@Override
	@Transactional(readOnly = true)
	public Evento read(Long id) {
		return daoEvento.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		daoEvento.deleteById(id);
	}
}
