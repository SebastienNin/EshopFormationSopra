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

	public interface CommandeWithDetails extends CommandeWithClient {
	}

	public interface CommandeDetail extends Common {
	}

	public interface CommandeDetailWithCommande extends CommandeDetail {
	}

	public interface CommandeDetailWithProduit extends CommandeDetailWithCommande {
	}

	public interface Commentaire extends Common {
	}

	public interface CommentaireWithProduit extends Commentaire {
	}

	public interface CommentaireWithClient extends CommentaireWithProduit {
	}

	public interface Personne extends Common {
	}

	public interface PersonneWithAdresses extends Personne {
	}

	public interface PersonneWithCommandes extends PersonneWithAdresses {
	}

	public interface PersonneWithProduits extends PersonneWithCommandes {
	}

	public interface Produit extends Common {
	}

	public interface ProduitWithFournisseur extends Produit {
	}

	public interface ProduitWithDetails extends ProduitWithFournisseur {
	}

	public interface ProduitWithCommentaires extends ProduitWithDetails {
	}

	public interface ProduitWithReparateurs extends ProduitWithCommentaires {
	}
	
	public interface Reparateur extends Common {
	}

	public interface ReparateurWithProduits extends Reparateur {
	}
}
