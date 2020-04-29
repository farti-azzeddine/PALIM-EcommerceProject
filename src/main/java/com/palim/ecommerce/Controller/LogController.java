package com.palim.ecommerce.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palim.ecommerce.Dao.ClientDao;
import com.palim.ecommerce.Entities.Categorie;
import com.palim.ecommerce.Entities.Client;

@Controller
public class LogController {

	
	
	@Autowired
	ClientDao clientdao;
	
	
	
	@RequestMapping("/loginn")
	public String loginn(Model model)
	{
		
		model.addAttribute("client",new Client());
		
		return "login/pagelogin";
	}
	
}
