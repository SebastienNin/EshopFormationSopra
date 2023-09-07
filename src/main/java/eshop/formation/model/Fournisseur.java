package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Fournisseur extends Personne {
	private String responsable;
	@OneToMany
	private List<Produit> produits = new ArrayList<>();
	@ManyToMany
	private List<Adresse> adresses = new ArrayList<>();

	public Fournisseur(Long id, int version, String nom, String adresse, String responsable) {
		super(nom, adresse);
		this.responsable = responsable;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return " > " + this.id + ". " + this.nom;
	}
}
