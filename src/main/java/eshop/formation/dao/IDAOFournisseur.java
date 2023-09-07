package eshop.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.formation.model.Fournisseur;

public interface IDAOFournisseur extends JpaRepository<Fournisseur,Integer> {

}
