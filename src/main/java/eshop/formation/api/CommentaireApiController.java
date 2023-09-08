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

import eshop.formation.dao.IDAOCommentaire;
import eshop.formation.model.Commentaire;
import eshop.formation.model.Views;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/commentaire")
public class CommentaireApiController {
	private IDAOCommentaire daoCommentaire;

	public CommentaireApiController(IDAOCommentaire daoCommentaire) {
		this.daoCommentaire = daoCommentaire;
	}

	@GetMapping("")
	@JsonView(Views.Commentaire.class)
	public List<Commentaire> findAll() {
		return daoCommentaire.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.CommentaireWithProduit.class)
	public Commentaire findById(@PathVariable int id) {
		return daoCommentaire.findById(id).get();
	}
	@GetMapping("/detail/{id}")
	@JsonView(Views.CommentaireWithClient.class)
	public Commentaire detailById(@PathVariable int id) {
		return daoCommentaire.findById(id).get();
	}
	@PostMapping("")
	//@JsonView(Views.Commentaire.class)
	public Commentaire create(@Valid @RequestBody Commentaire commentaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Commentaire invalide");
		}

		commentaire = daoCommentaire.save(commentaire);

		return commentaire;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.Commentaire.class)
	public Commentaire update(@RequestBody Commentaire commentaire, @PathVariable int id) {
		commentaire = daoCommentaire.save(commentaire);

		return commentaire;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoCommentaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoCommentaire.deleteById(id);
	}


}
