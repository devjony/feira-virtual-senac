package br.com.senacrio.feiravirtual.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoDomain;

@Repository
public interface EventoRepository extends JpaRepository<EventoDomain, Integer> {
}
