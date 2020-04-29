//package com.palim.ecommerce.Dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//
//import com.palim.ecommerce.Entities.*;
//
//@Repository
//public interface LigneCommandeDao extends JpaRepository<LigneCommande, Long> {
//	@Query("from LigneCommande where idLigneCommande=:var")
//	Commande getCommandeById(@Param("var") long idLiCom);
//}
// 
