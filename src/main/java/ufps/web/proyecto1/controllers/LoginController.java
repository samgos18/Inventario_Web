package ufps.web.proyecto1.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class LoginController {

	@GetMapping({"/login","","/"})
	public String login (Principal principal,Authentication auth) {
		
		if(principal==null) 
			return "login";
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
			return "redirect:/admin";
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USUARIO")))
			return "redirect:/usuario";
			
		
		return "password";
		
	}
	
	@GetMapping("/sign-up")
	public String registrarse () {
		
		return "registrarse";
	}
	
}
