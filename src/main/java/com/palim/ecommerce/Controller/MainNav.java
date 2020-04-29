package com.palim.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palim.ecommerce.Dao.CategorieDao;
import com.palim.ecommerce.Dao.ProduitDao;
import com.palim.ecommerce.Entities.Categorie;
import com.palim.ecommerce.Entities.Produit;


@Controller
public class MainNav {

	@Autowired
	ProduitDao produitDao;
	
	@Autowired
	CategorieDao categoriedao;
	
	@RequestMapping("/")
	public String go(Produit produit,Model model,Categorie categorie)
	{
		
		model.addAttribute("categorie",new Categorie());
		
		List<Categorie> categorie1 = new ArrayList<Categorie>();
		categorie1=categoriedao.findAll();
		model.addAttribute("nomcategorie",categorie1);
		//add list produit
		List<Produit> produit1 = new ArrayList<Produit>();
		produit1=produitDao.findAll();
		model.addAttribute("listproduit",produit1);
		return "home";
	}
	
	@RequestMapping("/cordonne")
	public String goo(Model model)
	{
		
		return "contact";
	}
	
}
