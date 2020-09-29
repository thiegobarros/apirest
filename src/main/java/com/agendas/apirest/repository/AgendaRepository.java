package com.agendas.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendas.apirest.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{

	Optional<Agenda> findById(Long id);
}
