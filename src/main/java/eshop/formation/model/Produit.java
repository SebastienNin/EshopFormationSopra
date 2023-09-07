package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Long id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@JsonView(Views.Common.class)
	private String libelle;
	@JsonView(Views.Common.class)
	private Double prixAchat;
	@JsonView(Views.Common.class)
	private Double prixVente;
	@JsonView(Views.Common.class)
	private String reference;
	@JsonView(Views.Common.class)
	private String modele;
	@JsonView(Views.Common.class)
	private int stock;
	@ManyToOne
	@JsonView(Views.ProduitWithFournisseur.class)
	private Fournisseur fournisseur;
	@OneToMany(mappedBy="produit")
	@JsonView(Views.ProduitWithDetails.class)
	private List<CommandeDetail> details = new ArrayList<>();
	@OneToMany(mappedBy="produit")
	@JsonView(Views.ProduitWithCommentaires.class)
	private List<Commentaire> commentaires = new ArrayList<>();
	@ManyToMany(mappedBy="produitsReparables")
	@JsonView(Views.ProduitWithReparateurs.class)
	private List<Reparateur> reparateurs = new ArrayList<>();

	public Produit(String libelle, Double prixAchat, Double prixVente, String reference,
			String modele, int stock, Fournisseur fournisseur) {
		super();
		this.libelle = libelle;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.reference = reference;
		this.modele = modele;
		this.stock = stock;
		this.fournisseur = fournisseur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CommandeDetail> details) {
		this.details = details;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Reparateur> getReparateurs() {
		return reparateurs;
	}

	public void setReparateurs(List<Reparateur> reparateurs) {
		this.reparateurs = reparateurs;
	}

	public Produit() { // IMPORTANT pour JPA

	}

	public Produit(String libelle) {
		this.libelle = libelle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return " > " + this.id + ". " + this.libelle + ", " + this.prixVente + " euros";
	}
}
