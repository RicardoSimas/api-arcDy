package br.unigranrio.arcd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unigranrio.arcd.domain.Monitoring;
import br.unigranrio.arcd.repositories.MonitoringRepository;

@Service
public class MonitoringService {
	
	@Autowired
	private MonitoringRepository repo;
	
	public Monitoring find(Integer id) {
		
		Monitoring obj = repo.findOne(id);
		
		return obj;
	}
}
