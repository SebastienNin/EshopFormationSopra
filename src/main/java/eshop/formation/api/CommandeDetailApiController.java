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

import eshop.formation.dao.IDAOCommandeDetail;
import eshop.formation.model.CommandeDetail;
import eshop.formation.model.Views;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/commandedetail")
public class CommandeDetailApiController {
	private IDAOCommandeDetail daoCommandeDetail;

	public CommandeDetailApiController(IDAOCommandeDetail daoCommandeDetail) {
		this.daoCommandeDetail = daoCommandeDetail;
	}

	@GetMapping("")
	@JsonView(Views.CommandeDetail.class)
	public List<CommandeDetail> findAll() {
		return daoCommandeDetail.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.CommandeDetailWithCommande.class)
	public CommandeDetail findById(@PathVariable int id) {
		return daoCommandeDetail.findById(id).get();
	}
	@GetMapping("/{id}/detail")
	@JsonView(Views.CommandeDetailWithProduit.class)
	public CommandeDetail detailById(@PathVariable int id) {
		return daoCommandeDetail.findById(id).get();
	}
	@PostMapping("")
	//@JsonView(Views.CommandeDetail.class)
	public CommandeDetail create(@Valid @RequestBody CommandeDetail commandedetail, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CommandeDetail invalide");
		}

		commandedetail = daoCommandeDetail.save(commandedetail);

		return commandedetail;
	}
	@PutMapping("/{id}")
	//@JsonView(Views.CommandeDetail.class)
	public CommandeDetail update(@RequestBody CommandeDetail commandedetail, @PathVariable int id) {
		commandedetail = daoCommandeDetail.save(commandedetail);

		return commandedetail;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoCommandeDetail.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoCommandeDetail.deleteById(id);
	}


}
