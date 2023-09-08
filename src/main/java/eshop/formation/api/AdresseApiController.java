package eshop.formation.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.formation.dao.IDAOAdresse;
import eshop.formation.model.Adresse;
import eshop.formation.model.Views;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/adresse")
public class AdresseApiController {
	private IDAOAdresse daoAdresse;

	public AdresseApiController(IDAOAdresse daoAdresse) {
		this.daoAdresse = daoAdresse;
	}

	@GetMapping("")
	@JsonView(Views.Adresse.class)
	public List<Adresse> findAll() {
		return daoAdresse.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.AdresseWithPersonne.class)
	public Adresse findById(@PathVariable int id) {
		return daoAdresse.findById(id).get();
	}
	/*@GetMapping("/detail/{id}")
	@JsonView(Views.AdresseWithOrdinateur.class)
	public Adresse detailById(@PathVariable int id) {
		return daoAdresse.findById(id).get();
	}*/
	@PostMapping("")
	//@JsonView(Views.Adresse.class)
	public Adresse create(@Valid @RequestBody Adresse adresse, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adresse invalide");
		}

		adresse = daoAdresse.save(adresse);

		return adresse;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.Adresse.class)
	public Adresse update(@RequestBody Adresse adresse, @PathVariable int id) {
		adresse = daoAdresse.save(adresse);

		return adresse;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoAdresse.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoAdresse.deleteById(id);
	}


}
