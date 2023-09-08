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

import eshop.formation.dao.IDAOPersonne;
import eshop.formation.model.Personne;
import eshop.formation.model.Views;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/personne")
public class PersonneApiController {
	private IDAOPersonne daoPersonne;

	public PersonneApiController(IDAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	@GetMapping("")
	@JsonView(Views.Personne.class)
	public List<Personne> findAll() {
		return daoPersonne.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.PersonneWithAdresses.class)
	public Personne findById(@PathVariable int id) {
		return daoPersonne.findById(id).get();
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.PersonneWithCommandes.class)
	public Personne detailById(@PathVariable int id) {
		return daoPersonne.findById(id).get();
	}
	
	@GetMapping("/detailproduit/{id}")
	@JsonView(Views.PersonneWithProduits.class)
	public Personne detailproduitById(@PathVariable int id) {
		return daoPersonne.findById(id).get();
	}

	@PostMapping("")
	// @JsonView(Views.Personne.class)
	public Personne create(@Valid @RequestBody Personne personne, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personne invalide");
		}

		personne = daoPersonne.save(personne);

		return personne;
	}

	@PutMapping("/{id}")
	// @JsonView(Views.Personne.class)
	public Personne update(@RequestBody Personne personne, @PathVariable int id) {
		personne = daoPersonne.save(personne);

		return personne;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if (!daoPersonne.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoPersonne.deleteById(id);
	}

}
