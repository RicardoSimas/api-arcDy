package br.unigranrio.arcd.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/monitoring")
public class MonitoringResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String testRest() {
		return "Teste de rest";
	}
}
