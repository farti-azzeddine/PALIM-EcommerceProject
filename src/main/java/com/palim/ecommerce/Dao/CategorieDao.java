package com.palim.ecommerce.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.palim.ecommerce.Entities.Categorie;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long> {
	@Query("from Categorie where idCategorie=:var")
	Categorie getCategorieById(@Param("var") long idCat);
}
