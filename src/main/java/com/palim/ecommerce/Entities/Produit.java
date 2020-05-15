package com.palim.ecommerce.Entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Produit implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
    @NotNull
    @Size(min = 1,max = 70)
	private String nomProduit;
	private int prix;
	private int quantite;
	@NotNull
    @Size(min = 1,max = 70)
	private String description;
	private String photos;
	private boolean disponible;

	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull
	@JoinColumn(name="idCategorie")
	private Categorie categorie;

	
	@OneToMany(mappedBy = "produit",fetch=FetchType.EAGER)
	private Collection<Commande> commandes;
	
	
	
//	@OneToMany(mappedBy = "produit")
//	private List<LigneCommande> ligneCommandes;
	
//	@OneToMany(mappedBy = "produit")
//	private Collection<LigneCommande> ligneCommandes;
	
	// Getters et Setters
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String nomProduit, int prix, int quantite, String description, boolean disponible,
			Categorie categorie, String photos) {
		super();
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
		this.photos = photos;
		this.disponible = disponible;
		this.categorie = categorie;
		
	}


	
	
	}
