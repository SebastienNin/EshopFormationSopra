package eshop.formation.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Long id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@JsonView(Views.Common.class)
	private Date date = new Date();
	@JsonView(Views.Common.class)
	private int note = 0;
	@JsonView(Views.Common.class)
	private String commentaire;
	@ManyToOne
	@JoinColumn(name="produit")
	@JsonView(Views.CommentaireWithProduit.class)
	private Produit produit;
	@OneToOne
	@JoinColumn(name="client")
	@JsonView(Views.CommentaireWithClient.class)
	private Client client;

	public Commentaire() {}

	public Commentaire(Date date, int note, String commentaire, Produit produit, Client client) {
		this.date = date;
		this.note = note;
		this.commentaire = commentaire;
		this.produit = produit;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
