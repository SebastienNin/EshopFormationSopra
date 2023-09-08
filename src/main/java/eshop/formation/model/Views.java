package eshop.formation.model;

public interface Views {
	public interface Common {
	}

	public interface Adresse extends Common {
	}

	public interface AdresseWithPersonne extends Common {
	}

	public interface Commande extends Common {
	}

	public interface CommandeWithClient extends Common {
	}

	public interface CommandeWithDetails extends Common {
	}

	public interface CommandeDetail extends Common {
	}

	public interface CommandeDetailWithCommande extends Common {
	}

	public interface CommandeDetailWithProduit extends Common {
	}

	public interface Commentaire extends Common {
	}

	public interface CommentaireWithProduit extends Common {
	}

	public interface CommentaireWithClient extends Common {
	}

	public interface Personne extends Common {
	}

	public interface PersonneWithAdresses extends Common {
	}

	public interface PersonneWithCommandes extends Common {
	}

	public interface PersonneWithProduits extends Common {
	}

	public interface Produit extends Common {
	}

	public interface ProduitWithFournisseur extends Common {
	}

	public interface ProduitWithDetails extends Common {
	}

	public interface ProduitWithCommentaires extends Common {
	}

	public interface ProduitWithReparateurs extends Common {
	}
	
	public interface Reparateur extends Common {
	}

	public interface ReparateurWithProduits extends Common {
	}
}
