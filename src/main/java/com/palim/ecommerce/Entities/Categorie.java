package com.palim.ecommerce.Entities;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Categorie implements Serializable  {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie; 

	
	
	
    @OneToMany(mappedBy = "categorie",fetch=FetchType.EAGER)
	private List<Produit> produits ;
//    private Collection<Produit> produits=new ArrayList<Produit>();
    
// Getters et Setters
 

	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	
	
	
//	public Collection<Produit> getProduits() {
//		return produits;
//	}
//	public void setProduits(Collection<Produit> produits) {
//		this.produits = produits;
//	}
	
	
    public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	// Constructeurs sans paramètres
	public Categorie() {
		
	}
	// Constructeurs avec paramètres
	public Categorie(String nomCategorie) {
		
		this.nomCategorie = nomCategorie;
		
	}
	
	
}
