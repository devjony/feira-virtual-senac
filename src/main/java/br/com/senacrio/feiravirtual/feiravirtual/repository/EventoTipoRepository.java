package br.com.senacrio.feiravirtual.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoTipoDomain;

public interface EventoTipoRepository extends JpaRepository<EventoTipoDomain, Integer> {

}
