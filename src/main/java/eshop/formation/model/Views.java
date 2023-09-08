package eshop.formation.model;

public interface Views {
	public interface Common {
	}

	public interface Adresse extends Common {
	}

	public interface AdresseWithPersonne extends Adresse {
	}
	
	public interface AdresseWithFournisseur extends AdresseWithPersonne {
	}

	public interface Commande extends Common {
	}

	public interface CommandeWithClient extends Commande {
	}

	public interface CommandeWithDetailsAndClient extends CommandeWithClient {
	}

	public interface CommandeDetail extends Common {
	}

	public interface CommandeDetailWithCommande extends CommandeDetail {
	}

	public interface CommandeDetailWithProduitAndCommande extends CommandeDetailWithCommande {
	}

	public interface Commentaire extends Common {
	}

	public interface CommentaireWithProduit extends Commentaire {
	}

	public interface CommentaireWithClientAndProduit extends CommentaireWithProduit {
	}

	public interface Personne extends Common {
	}

	public interface PersonneWithAdresses extends Personne {
	}

	public interface PersonneWithCommandesAndAdresses extends PersonneWithAdresses {
	}

	public interface PersonneWithProduitsAndCommandesAndAdresses extends PersonneWithCommandesAndAdresses {
	}

	public interface Produit extends Common {
	}

	public interface ProduitWithFournisseur extends Produit {
	}

	public interface ProduitWithDetailsAdnFournisseur extends ProduitWithFournisseur {
	}

	public interface ProduitWithCommentairesAndDetailsAdnFournisseur extends ProduitWithDetailsAdnFournisseur {
	}

	public interface ProduitWithReparateurs extends ProduitWithCommentairesAndDetailsAdnFournisseur {
	}
	
	public interface Reparateur extends Common {
	}

	public interface ReparateurWithProduits extends Reparateur {
	}
}
