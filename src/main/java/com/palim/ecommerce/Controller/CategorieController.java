package com.palim.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//je suis ss

import com.palim.ecommerce.Dao.CategorieDao;
import com.palim.ecommerce.Entities.*;


@Controller
public class CategorieController {

	@Autowired
	CategorieDao categoriedao;

	@RequestMapping("/AjouterCategorie")
	public String ajoutercategorie(Model model)
	{
		
		model.addAttribute("categorie",new Categorie());
		
		return "categorie/pageajoutercategorie";
	}
	@RequestMapping("/AjouterCategorieconfirmer")
	public String ajoutercategorieconfirmer(Categorie categorie ,Model model)
	{
		categoriedao.save(categorie);
		
		//return "redirect:/";
     	return "redirect:/AfficherListCat";
	}
	
	@RequestMapping("/AfficherListCat")
	public String AfficherListCat(Categorie categorie ,Model model)
	{
		List<Categorie> categorie1 = new ArrayList<Categorie>();
		categorie1=categoriedao.findAll();
		model.addAttribute("listcategorie",categorie1);
		
		return "categorie/pageListCat";
	}
			
	@RequestMapping("/SupprimerCat")
	public String SupprimerCat(Categorie categorie ,Model model, @RequestParam("idCat")Long idCat)
	{
		categoriedao.delete(categoriedao.getCategorieById(idCat));
		List<Categorie> categorie1 = new ArrayList<Categorie>();
		categorie1=categoriedao.findAll();
		model.addAttribute("listcategorie",categorie1);
		
		return "categorie/pageListCat";
	}
	
	@RequestMapping("/ModifierCat")
	public String ModifierCat(Model model, @RequestParam("idCat")Long idCat)
	{
		
		Categorie categorie=categoriedao.findById(idCat).get();
		model.addAttribute("categorie",categorie);
		

		return "categorie/pageModifierCat";
	}
	
	
	@RequestMapping("/ModifierCategorieconfirmer")
	public String modifiercategorieconfirmer(Categorie categorie ,Model model)
	{
		categoriedao.save(categorie);
		
		List<Categorie> categorie1 = new ArrayList<Categorie>();
		categorie1=categoriedao.findAll();
		model.addAttribute("listcategorie",categorie1);
		
		return "categorie/pageListCat";
}
}