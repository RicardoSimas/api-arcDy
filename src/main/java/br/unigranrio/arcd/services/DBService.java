package br.unigranrio.arcd.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unigranrio.arcd.domain.Monitoring;
import br.unigranrio.arcd.repositories.MonitoringRepository;

@Service
public class DBService {
	
	@Autowired
	MonitoringRepository repo;
	
	public void instantiateTestDatabase() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Monitoring m1 = new Monitoring(null, 18.2, 6.8, sdf.parse("21/10/1995"));
		Monitoring m2 = new Monitoring(null, 23.2, 9.6, sdf.parse("21/10/1995"));
		Monitoring m3 = new Monitoring(null, 10.2, 4.2, sdf.parse("21/10/1995"));
		Monitoring m4 = new Monitoring(null, 8.2, 2.7, sdf.parse("21/10/1995"));

		repo.save(Arrays.asList(m1,m2,m3,m4));
	}
}
