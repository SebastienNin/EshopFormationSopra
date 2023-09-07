package eshop.formation.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.formation.dao.IDAOAdresse;
import eshop.formation.model.Adresse;

public class PopulateTest {

	@Autowired
	IDAOAdresse daoAdresse;

	public void run(String... args) {
		Optional<Adresse> opt = daoAdresse.findById(1);
		
	}

//	@Test
//	public void populate() {
//		
//		
//	}
}
