package com.agendas.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.apirest.repository.AgendaRepository;
import com.agendas.apirest.models.Agenda;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class AgendaResource {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	@GetMapping("/agendas")
	public List<Agenda> ListaAgendas(){
		return agendaRepository.findAll();
	}

	@GetMapping("/agenda/{id}")
	public Agenda ListaAgendaUnica(@PathVariable(value="id") Long id){
		Optional<Agenda> find = agendaRepository.findById(id);
		if (find.isPresent()) {
			return find.get();
		}
		return null;
	}
	
	@PostMapping("/agenda")
	public Agenda salvaAgenda(@RequestBody Agenda agenda){
		return agendaRepository.save(agenda);
	}
	
	@DeleteMapping("/agenda")
	public void deletaAgenda(@RequestBody Agenda agenda){
		agendaRepository.delete(agenda);
	}
	
	@PutMapping("/agenda")
	public Agenda atualizaAgenda(@RequestBody Agenda agenda){
		return agendaRepository.save(agenda);
	}
}
