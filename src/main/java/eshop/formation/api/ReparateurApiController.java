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

import eshop.formation.dao.IDAOReparateur;
import eshop.formation.model.Reparateur;
import eshop.formation.model.Views;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/repararteur")
public class ReparateurApiController {
	private IDAOReparateur daoReparateur;

	public ReparateurApiController(IDAOReparateur daoReparateur) {
		this.daoReparateur = daoReparateur;
	}

	@GetMapping("")
	@JsonView(Views.Reparateur.class)
	public List<Reparateur> findAll() {
		return daoReparateur.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ReparateurWithProduits.class)
	public Reparateur findById(@PathVariable int id) {
		return daoReparateur.findById(id).get();
	}
	/*@GetMapping("/detail/{id}")
	@JsonView(Views.ReparateurWithOrdinateur.class)
	public Reparateur detailById(@PathVariable int id) {
		return daoReparateur.findById(id).get();
	}*/
	@PostMapping("")
	//@JsonView(Views.Reparateur.class)
	public Reparateur create(@Valid @RequestBody Reparateur repararteur, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reparateur invalide");
		}

		repararteur = daoReparateur.save(repararteur);

		return repararteur;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.Reparateur.class)
	public Reparateur update(@RequestBody Reparateur repararteur, @PathVariable int id) {
		repararteur = daoReparateur.save(repararteur);

		return repararteur;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoReparateur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoReparateur.deleteById(id);
	}


}
