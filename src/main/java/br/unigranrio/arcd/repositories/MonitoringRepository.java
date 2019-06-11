package br.unigranrio.arcd.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigranrio.arcd.domain.Monitoring;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Integer>{
	
	Page<Monitoring> findByregistroDataBetween(Date dataInicio, Date dataFim, Pageable pageRequest);
}
