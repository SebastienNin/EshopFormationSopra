package eshop.formation.model;

public interface Views {
	public interface Common {
	}

	public interface Adresse extends Common {
	}

	public interface AdresseWithPersonne extends Adresse {
	}
	
	public interface AdresseWithFournisseur extends Adresse {
	}

	public interface Commande extends Common {
	}

	public interface CommandeWithClient extends Commande {
	}

	public interface CommandeWithDetails extends Commande {
	}

	public interface CommandeDetail extends Common {
	}

	public interface CommandeDetailWithCommande extends CommandeDetail {
	}

	public interface CommandeDetailWithProduit extends CommandeDetail {
	}

	public interface Commentaire extends Common {
	}

	public interface CommentaireWithProduit extends Commentaire {
	}

	public interface CommentaireWithClient extends Commentaire {
	}

	public interface Personne extends Common {
	}

	public interface PersonneWithAdresses extends Personne {
	}

	public interface PersonneWithCommandes extends Personne {
	}

	public interface PersonneWithProduits extends Personne {
	}

	public interface Produit extends Common {
	}

	public interface ProduitWithFournisseur extends Produit {
	}

	public interface ProduitWithDetails extends Produit {
	}

	public interface ProduitWithCommentaires extends Produit {
	}

	public interface ProduitWithReparateurs extends Produit {
	}
	
	public interface Reparateur extends Common {
	}

	public interface ReparateurWithProduits extends Reparateur {
	}
}
