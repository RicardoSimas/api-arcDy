package br.unigranrio.arcd.resources;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unigranrio.arcd.domain.Monitoring;
import br.unigranrio.arcd.resources.utils.URL;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Monitoring obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Monitoring>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {

		Page<Monitoring> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page/datas", method=RequestMethod.GET)
	public ResponseEntity<Page<Monitoring>> findPage(
			@RequestParam(value="dataIni", defaultValue="") String dataIni, 
			@RequestParam(value="dataFim", defaultValue="") String dataFim, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {

		Date nomeDecoded1 = URL.decodeDate(dataIni);
		Date nomeDecoded2 = URL.decodeDate(dataFim);

		Page<Monitoring> list = service.search(nomeDecoded1, nomeDecoded2, page,
				linesPerPage, orderBy, direction);

		System.out.println("TESTANNNDO");
		System.out.println(dataFim);
		return ResponseEntity.ok().body(list);
	}
}
