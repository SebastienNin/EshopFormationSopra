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

import eshop.formation.dao.IDAOProduit;
import eshop.formation.model.Produit;
import eshop.formation.model.Views;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/produit")
public class ProduitApiController {
	private IDAOProduit daoProduit;

	public ProduitApiController(IDAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}

	@GetMapping("")
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return daoProduit.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit findById(@PathVariable int id) {
		return daoProduit.findById(id).get();
	}
	@GetMapping("/{id}/detail")
	@JsonView(Views.ProduitWithFournisseur.class)
	public Produit detailById(@PathVariable int id) {
		return daoProduit.findById(id).get();
	}
	@GetMapping("/{id}/detail/commentaire")
	@JsonView(Views.ProduitWithCommentaires.class)
	public Produit detailcommentaireById(@PathVariable int id) {
		return daoProduit.findById(id).get();
	}
	@GetMapping("/{id}/detail/reparateur")
	@JsonView(Views.ProduitWithReparateurs.class)
	public Produit detailsrepararteurById(@PathVariable int id) {
		return daoProduit.findById(id).get();
	}
	@PostMapping("")
	//@JsonView(Views.Produit.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produit invalide");
		}

		produit = daoProduit.save(produit);

		return produit;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.Produit.class)
	public Produit update(@RequestBody Produit produit, @PathVariable int id) {
		produit = daoProduit.save(produit);

		return produit;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoProduit.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoProduit.deleteById(id);
	}


}
