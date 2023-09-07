package eshop.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysql.cj.xdevapi.Client;

public interface IDAOClient extends JpaRepository<Client,Integer> {

}
