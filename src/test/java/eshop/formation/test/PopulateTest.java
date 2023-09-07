package eshop.formation.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.formation.dao.IDAOAdresse;
import eshop.formation.dao.IDAOCommande;
import eshop.formation.dao.IDAOCommandeDetail;
import eshop.formation.dao.IDAOFournisseur;
import eshop.formation.dao.IDAOPersonne;
import eshop.formation.dao.IDAOProduit;
import eshop.formation.dao.IDAOReparateur;
import eshop.formation.model.Adresse;
import eshop.formation.model.Client;
import eshop.formation.model.Commande;
import eshop.formation.model.CommandeDetail;
import eshop.formation.model.Commentaire;
import eshop.formation.model.EtatCommande;
import eshop.formation.model.Fournisseur;
import eshop.formation.model.Produit;
import eshop.formation.model.Reparateur;

public class PopulateTest {

	@Autowired
	IDAOAdresse daoAdresse;
	@Autowired
	IDAOCommande daoCommande;
	@Autowired
	IDAOCommandeDetail daoCommandeDetail;
	@Autowired
	IDAOFournisseur daoFournisseur;
	@Autowired
	IDAOPersonne daoPersonne;
	@Autowired
	IDAOProduit daoProduit;
	@Autowired
	IDAOReparateur daoReparateur;

	public void run(String... args) {

		//Creation des objets
		Client client1 = new Client("Diallo", "tidiane@gmail.com", "Tidiane");
		Client client2 = new Client("Nin", "sebastien@gmail.com", "Sébastien");

		Adresse adresse1 = new Adresse("8 rue de la paix", "Paris", "75001", client1);
		Adresse adresse2 = new Adresse("9 rue de la paix", "Paris", "75001", client2);

		Commande commande1 = new Commande(Date.valueOf("2023-09-07"), 75.00, EtatCommande.valueOf("ENCOURS"), client1);
		Commande commande2 = new Commande(Date.valueOf("2023-08-07"), 70.50, EtatCommande.valueOf("TERMINEE"), client2);

		Fournisseur fournisseur1 = new Fournisseur("Abid", "Jardin de Jordan", "Eric");

		Produit produit1 = new Produit("Pomme", 3.00, 5.00, "Pomme Golden", "Jaune", 100, fournisseur1);
		Produit produit2 = new Produit("Poire", 4.00, 6.00, "Super Poire", "Vert", 120, fournisseur1);

		CommandeDetail detail1 = new CommandeDetail(75.50, 1, null, commande1);
		CommandeDetail detail2 = new CommandeDetail(70.50, 1, null, commande2);

		Commentaire commentaire1 = new Commentaire(Date.valueOf("2023-09-07"), 5, "Très sucré", produit1,
				client1);
		Commentaire commentaire2 = new Commentaire(Date.valueOf("2023-08-07"), 5, "Très bon et sucré", produit2,
				client2);

		Reparateur reparateur1 = new Reparateur("Sultan", "1234567890", "Réparateur de pomme et des poires");

		// Envoi en base
		daoPersonne.save(client1);
		daoPersonne.save(client2);
		
		daoAdresse.save(adresse1);
		daoAdresse.save(adresse2);
		
		// Set des listes
		adresse1.getFournisseurs().add(fournisseur1);
		adresse2.getFournisseurs().add(fournisseur1);
		
		commande1.getDetails().add(detail1);
		commande2.getDetails().add(detail2);
		
		client2.getCommandes().add(commande2);
		client1.getCommandes().add(commande1);
		
		List<Adresse> listAdresse1 = new ArrayList();
		Collections.addAll(listAdresse1, adresse1, adresse2);
		
		client1.setAdresses(listAdresse1);
		client2.setAdresses(listAdresse1);
		
		Collections.addAll(fournisseur1.getProduits(), produit1, produit2);
		Collections.addAll(fournisseur1.getAdresses(), adresse1, adresse2);
		
		produit1.getDetails().add(detail1);
		produit2.getDetails().add(detail2);
		
		produit1.getCommentaires().add(commentaire1);
		produit2.getCommentaires().add(commentaire2);
		
		produit1.getReparateurs().add(reparateur1);
		produit2.getReparateurs().add(reparateur1);
		
		Collections.addAll(reparateur1.getProduitsReparables(), produit1, produit2);
		

		
		}

//	@Test
//	public void populate() {
//		
//		
//	}
}
