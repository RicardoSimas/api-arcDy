package br.unigranrio.arcd.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unigranrio.arcd.domain.Monitoring;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Monitoring obj"
			+ " WHERE obj.registroData BETWEEN dataIni AND dataFim")
	Page<Monitoring> search(
			@Param("dataIni") Date dataIni,
			@Param("dataFim") Date dataFim,
			Pageable pageRequest);
}
