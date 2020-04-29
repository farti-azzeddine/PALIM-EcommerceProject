package com.palim.ecommerce.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palim.ecommerce.Entities.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
	@Query("from Client where idClient=:var")
	Client getClientById(@Param("var") long idCli);
}
