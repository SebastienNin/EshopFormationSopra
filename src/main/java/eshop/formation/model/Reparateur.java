package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Version;

@Entity
public class Reparateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String nom;
	private String telephone;
	private String description;
	@ManyToMany
	@JoinColumn(name="reparateurs")
	private List<Produit> produitsReparables = new ArrayList<>();

	public Reparateur() {
		// TODO Auto-generated constructor stub
	}
	
	public Reparateur(String nom, String telephone, String description) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getProduitsReparables() {
		return produitsReparables;
	}

	public void setProduitsReparables(List<Produit> produitsReparables) {
		this.produitsReparables = produitsReparables;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
