package com.palim.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palim.ecommerce.Dao.*;

import com.palim.ecommerce.Entities.*;


@Controller

public class ClientController {

	@Autowired
	ClientDao clientdao;

	
	@RequestMapping("/inscrireClient")
	public String ajouterclient(Model model)
	{
		
		model.addAttribute("client",new Client());
		
		return "client/pageajouterclient";
	}
	
	@RequestMapping("/AjouterClientconfirmer")
	public String ajoutercategorieconfirmer(Client client ,Model model)
	{
		clientdao.save(client);
		
		//return "redirect:/";
    	return "redirect:/AfficherClient";
	}
	
	@RequestMapping("/AfficherClient")
	public String AfficherClient(Client client ,Model model)
	{
		List<Client> client1 = new ArrayList<Client>();
		client1=clientdao.findAll();
		model.addAttribute("listclient",client1);
		
		return "client/pageListClient";
}

	@RequestMapping("/ModifierClient")
	public String ModifierClient(Model model, @RequestParam("idCli")Long idCli)
	{
		Client client=clientdao.findById(idCli).get();
		model.addAttribute("clientModifier",client);
		
		return "client/pageModifierClient";
	}
	
	@RequestMapping("/ModifierModifierClient")
	public String modifierModifierClient(Client client ,Model model)
	{
		clientdao.save(client);
		
         List<Client> client1 = new ArrayList<Client>();
	     client1=clientdao.findAll();
	     model.addAttribute("listclient",client1);
		return "client/pageListClient";	
	}
	
	
	@RequestMapping("/SupprimerClient")
	public String SupprimerClient(Client client ,Model model, @RequestParam("idCli")Long idCli)
	{
		clientdao.delete(clientdao.getClientById(idCli));
		List<Client> client1 = new ArrayList<Client>();
		client1=clientdao.findAll();
		model.addAttribute("listclient",client1);
		
		return "client/pageListClient";
	}
	
}
