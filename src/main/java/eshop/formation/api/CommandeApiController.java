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

import eshop.formation.dao.IDAOCommande;
import eshop.formation.model.Commande;
import eshop.formation.model.Views;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/commande")
public class CommandeApiController {
	private IDAOCommande daoCommande;

	public CommandeApiController(IDAOCommande daoCommande) {
		this.daoCommande = daoCommande;
	}

	@GetMapping("")
	@JsonView(Views.Commande.class)
	public List<Commande> findAll() {
		return daoCommande.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.CommandeWithClient.class)
	public Commande findById(@PathVariable int id) {
		return daoCommande.findById(id).get();
	}
	@GetMapping("/{id}/detail")
	@JsonView(Views.CommandeWithDetails.class)
	public Commande detailById(@PathVariable int id) {
		return daoCommande.findById(id).get();
	}
	@PostMapping("")
	//@JsonView(Views.Commande.class)
	public Commande create(@Valid @RequestBody Commande commande, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Commande invalide");
		}

		commande = daoCommande.save(commande);

		return commande;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.Commande.class)
	public Commande update(@RequestBody Commande commande, @PathVariable int id) {
		commande = daoCommande.save(commande);

		return commande;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoCommande.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoCommande.deleteById(id);
	}


}
