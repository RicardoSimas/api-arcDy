package br.unigranrio.arcd.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unigranrio.arcd.domain.Monitoring;
import br.unigranrio.arcd.services.MonitoringService;

@RestController
@RequestMapping(value = "/monitoring")
public class MonitoringResource {
	
	@Autowired
	private MonitoringService service;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Monitoring> find(@PathVariable Integer id) {

		Monitoring obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}
}
