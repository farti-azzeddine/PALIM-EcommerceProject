package com.palim.ecommerce.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;
	@NotNull
    @Size(min = 1,max = 70)
	private String nomClient;
	@NotNull
	@Size(min = 1,max = 90)
	private String adresse;
	@NotNull
    @Size(min = 1,max = 70)
	private String email;
	@NotNull
    @Size(min = 1,max = 70)
	private String tel;
	@NotNull
    @Size(min = 1,max = 70)
	private String password;

	@OneToMany(mappedBy="client" ,fetch=FetchType.EAGER)
	private Collection<Commande> commandes;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client() {
		
	}

	public Client(String nomClient, String adresse, String email, String tel, String password) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.password = password;
	}

	
	
	
	
}
 