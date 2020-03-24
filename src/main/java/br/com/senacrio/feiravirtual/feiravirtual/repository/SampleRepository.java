package br.com.senacrio.feiravirtual.feiravirtual.repository;

import br.com.senacrio.feiravirtual.feiravirtual.domain.SampleDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleDomain, Integer> {
}
