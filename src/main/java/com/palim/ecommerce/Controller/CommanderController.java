package com.palim.ecommerce.Controller;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.palim.ecommerce.Dao.*;
import com.palim.ecommerce.Entities.*;

@Controller
public class CommanderController {

	@Autowired
	ProduitDao produitdao;
	@Autowired
	CategorieDao categoriedao;
	
	@Autowired
	ClientDao clientdao;
	
	@Autowired
	CommandeDao commandedao;


	@RequestMapping("/CommanderProduit")
	public String commanderProduit(Model model , @RequestParam("idPro")Produit idPro,Client client)
	{
        Commande commande =new Commande();
		
		client.setIdClient(7L);
		commande.setProduit(idPro);
		commande.setClient(client);
		//model.addAttribute("commande",commande);
		commandedao.save(commande);
		System.out.println("hhhhh"+commande.getIdCommande());
		Commande commande1;
		
		commande1=commandedao.findById(commande.getIdCommande()).get();
		model.addAttribute("commandeById",commande1);
		return "commande/enregistrerLacommande";
	}
	
	
	@RequestMapping("/AjouterCommandeconfirmer")
	public String ajouterCommandeconfirmer(Commande commande , Model model)

	{
		System.out.println("hi ");
		
		commandedao.save(commande);
		System.out.println(commande.getIdCommande());
		Commande commande1;
		
		commande1=commandedao.findById(commande.getIdCommande()).get();
		model.addAttribute("commandeById",commande1);
		
//		return "redirect:/commande/enregistrerLacommande";
		return "commande/enregistrerLacommande";

	}
	
	@RequestMapping("/AfficherListCommande")
	public String afficherlistcommande(Produit produit ,Model model, Client client)

	{
		List<Commande> commande1 = new ArrayList<Commande>();
		commande1=commandedao.findAll();
		model.addAttribute("listcommande",commande1);
		
		return "commande/listcommande";

	}
	
	
	
	@RequestMapping("/SupprimerCommande")
	public String SupprimerProduit( Produit produit ,Model model, @RequestParam("idCom")Long idCom)
	{
		commandedao.delete(commandedao.getCommandeById(idCom));
		List<Commande> commande1 = new ArrayList<Commande>();
		commande1=commandedao.findAll();
		model.addAttribute("listcommande",commande1);
		
		return "commande/listcommande";
	}
	
}
