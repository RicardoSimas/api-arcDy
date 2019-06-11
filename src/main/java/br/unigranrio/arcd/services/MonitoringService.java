package br.unigranrio.arcd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unigranrio.arcd.domain.Monitoring;
import br.unigranrio.arcd.repositories.MonitoringRepository;
import br.unigranrio.arcd.resources.exceptions.ObjectNotFoundException;


@Service
public class MonitoringService {
	
	@Autowired
	private MonitoringRepository repo;
	
	public Monitoring find(Integer id) {
		
		Monitoring obj = repo.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto com id: "+ id + " não encontrado!");
		}
		
		return obj;
	}
	
	@Transactional
	public Monitoring insert(Monitoring obj) {
		obj.setId(null);;
		obj = repo.save(obj);
		System.out.println(obj);
		
		return obj;
	}
}
