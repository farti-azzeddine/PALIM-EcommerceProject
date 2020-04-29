//package com.palim.ecommerce.Entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.*;
//
//@Entity
//public class LigneCommande implements Serializable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long idLigneCommande;
//	private int quantite;
//	private double prix;
//
//	@ManyToOne
//	@JoinColumn(name="idProduit")
//	private Produit produit;
//	
//	@ManyToOne
//	@JoinColumn(name="idCommande")
//	private Commande commande;
//	
//	
//	public Long getIdLigneCommande() {
//		return idLigneCommande;
//	}
//	public void setIdLigneCommande(Long idLigneCommande) {
//		this.idLigneCommande = idLigneCommande;
//	}
//	public int getQuantite() {
//		return quantite;
//	}
//	public void setQuantite(int quantite) {
//		this.quantite = quantite;
//	}
//	public double getPrix() {
//		return prix;
//	}
//	public void setPrix(double prix) {
//		this.prix = prix;
//	}
//	public Produit getProduit() {
//		return produit;
//	}
//	public void setProduit(Produit produit) {
//		this.produit = produit;
//	}
//	public Commande getCommande() {
//		return commande;
//	}
//	public void setCommande(Commande commande) {
//		this.commande = commande;
//	}
//	public LigneCommande() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public LigneCommande(int quantite, double prix) {
//		super();
//		this.quantite = quantite;
//		this.prix = prix;
//	}
//	
//	
//
//}
