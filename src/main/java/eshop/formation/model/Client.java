package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Client extends Personne {
	@JsonView(Views.Common.class)
	private String prenom;
	@OneToMany(mappedBy = "client")
	@JsonView(Views.PersonneWithCommandes.class)
	private List<Commande> commandes = new ArrayList<>();
	@OneToMany(mappedBy = "client")
	@JsonView(Views.PersonneWithAdresses.class)
	private List<Adresse> adresses;
	
	public Client() {
	}

	public Client(String nom, String adresse, String prenom) {
		super(nom, adresse);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
}
