package com.palim.ecommerce.Controller;

import java.io.File;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.palim.ecommerce.Dao.CategorieDao;
import com.palim.ecommerce.Dao.ClientDao;
import com.palim.ecommerce.Dao.CommandeDao;
import com.palim.ecommerce.Dao.ProduitDao;
import com.palim.ecommerce.Entities.Categorie;
import com.palim.ecommerce.Entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitDao produitdao;
	
	@Autowired
	CategorieDao categoriedao;
	
	@Autowired
	ClientDao clientdao;
	
	@Autowired
	CommandeDao commandedao;
	
	
	@RequestMapping("/AjouterProduit")
	public String ajouterproduit(Model model , Categorie categorie)
	{
		model.addAttribute("produit",new Produit());
		return "produit/productForm";
	}
	
	@RequestMapping("/AjouterProduitconfirmer")
	public String ajouterproduitconfirmer(Produit produit ,Model model)
	{
		produitdao.save(produit);
		System.out.println(produit.getIdProduit());
		Produit produit1;
		produit1=produitdao.findById(produit.getIdProduit()).get();
		model.addAttribute("produitById",produit1);
		
		
		
		return "redirect:/AfficherListProduit";

	}
	@RequestMapping("/AfficherListProduit")
	public String AfficherListProduit(Produit produit ,Model model, Categorie categorie)
	{
		List<Produit> produit1 = new ArrayList<Produit>();
		produit1=produitdao.findAll();
		model.addAttribute("listproduit",produit1);
		return "produit/productList";
	}
	
	@RequestMapping("/AfficherListProduitVisiteur")
	public String AfficherListProduitvisiteur(Produit produit ,Model model, Categorie categorie)
	{
		List<Produit> produit1 = new ArrayList<Produit>();
		produit1=produitdao.findAll();
		model.addAttribute("listproduit",produit1);
		
		return "produit/pageListProduitvisiteur";
	}
	
	@RequestMapping("/AfficherProdBycat")
	public String AfficherProdBycat(Produit produit ,Model model,@RequestParam("idCatPro")Long idCatPro)
	{ 
			
		List<Categorie> categorie1 = new ArrayList<Categorie>();
		categorie1=categoriedao.findAll();
		model.addAttribute("nomcategorie",categorie1);
		List<Produit> produit1 = new ArrayList<Produit>();
		System.out.println("hi");
		produit1=produitdao.findAllById(idCatPro);
		model.addAttribute("listproduitCat",produit1);
		
		return "produit/afficheproBycat.html";
	}
	
	@RequestMapping("/ModifierProduit")
	public String ModifierProduit(Model model, @RequestParam("idPro")Long idPro)
	{
		Produit produit=produitdao.findById(idPro).get();
		model.addAttribute("produit",produit);
		
		return "produit/pageModifierProduit";
	}
	
	@RequestMapping("/showProduct")
	public String ShowProduct(Model model, @RequestParam("idPro")Long idPro)
	{
		Produit produit=produitdao.findById(idPro).get();
		model.addAttribute("produit",produit);
		
		return "produit/productDescription";
	}
	
	@RequestMapping("/ModifierProduitconfirmer")
	public String modifierProduitconfirmer(Produit produit ,Model model)
	{
			produitdao.save(produit);
		
		List<Produit> produit1 = new ArrayList<Produit>();
		produit1=produitdao.findAll();
		model.addAttribute("listproduit",produit1);
		return "redirect:/AfficherListProduit";	
	}
		
	
	@RequestMapping("/SupprimerProduit")
	public String SupprimerProduit( Produit produit ,Model model, @RequestParam("idPro")Long idPro)
	{
		produitdao.delete(produitdao.getProduitById(idPro));
		List<Produit> produit1 = new ArrayList<Produit>();
		produit1=produitdao.findAll();
//		si la commande est efectue par ce produit 
//		il faut le supprimer aussi de la commande
//		commandedao.delete(commandedao.getOne(idPro));
		model.addAttribute("listproduit",produit1);
		
		return "produit/productList";
	}
	@RequestMapping("/SupprimerProduitajouter")
	public String SupprimerProduitajouter( Produit produit ,Model model, @RequestParam("idPro")Long idPro)
	{
		produitdao.delete(produitdao.getProduitById(idPro));
		
		return "redirect:/";

	}
	}
