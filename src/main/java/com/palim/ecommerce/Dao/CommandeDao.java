package com.palim.ecommerce.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.palim.ecommerce.Entities.*;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
	@Query("from Commande where idCommande=:var")
	Commande getCommandeById(@Param("var") long idCom);
}
