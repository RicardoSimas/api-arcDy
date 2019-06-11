package br.unigranrio.arcd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigranrio.arcd.domain.Monitoring;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Integer>{
	
}
