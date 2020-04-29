package com.palim.ecommerce.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palim.ecommerce.Entities.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {

	@Query("from Produit where idProduit=:var")
	Produit getProduitById(@Param("var") long idPro);
	
	@Query("from Produit where idCategorie=:var1")
	Produit getProduitByCategorie(@Param("var1") long idCatPro);

	

	@Query("from Produit where idCategorie=:var2")
	List<Produit> findAllById(@Param("var2") Long idCatPro);
	
	//List<Produit> findById(@Param("var1") long idCatPro);
}
